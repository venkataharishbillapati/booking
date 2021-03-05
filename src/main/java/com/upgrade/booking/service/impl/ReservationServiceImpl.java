/*******************************************************************************
 * @author Harish Billapati
 *******************************************************************************/

package com.upgrade.booking.service.impl;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.upgrade.booking.BO.ReservationBO;
import com.upgrade.booking.DAO.AvailabilityDAO;
import com.upgrade.booking.DAO.VisitorBookingDataDAO;
import com.upgrade.booking.constants.BookingStatus;
import com.upgrade.booking.constants.DateFormat;
import com.upgrade.booking.entities.Availability;
import com.upgrade.booking.entities.VisitorBookingData;
import com.upgrade.booking.exceptionhandling.ApiGenericFieldValidationException;
import com.upgrade.booking.service.ReservationService;
import com.upgrade.booking.transformers.ReservationTransformer;
import com.upgrade.booking.utils.DateUtils;
import com.upgrade.booking.validator.ReservationValidator;

@Service
public class ReservationServiceImpl implements ReservationService {

	@Autowired
	private VisitorBookingDataDAO visitorBookingDataDAO;

	@Autowired
	private AvailabilityDAO availabilityDAO;

	private static final Logger log = LoggerFactory.getLogger(ReservationServiceImpl.class);

	@Override
	public ReservationBO bookReservation(ReservationBO reservationBO) {

		ReservationValidator.validateCreateReservationRequest(reservationBO);

		Date checkInDate = DateUtils.toDate(DateFormat.standardDateFormat.getValue(), reservationBO.getCheckInDate());
		Date checkOutDate = DateUtils.toDate(DateFormat.standardDateFormat.getValue(), reservationBO.getCheckOutDate());

		VisitorBookingData visitorBookingData = this.validateAvailableDatesAndVisitorsAndSavingInDatabase(checkInDate,
				checkOutDate, reservationBO);

		/*
		 * Creating the Reservation Respnse BO
		 */
		reservationBO = ReservationTransformer.transformReservationEntityToReservationBO(visitorBookingData,
				new ReservationBO());

		return reservationBO;
	}

	@Override
	public ReservationBO updateReservation(ReservationBO reservationBO) {

		ReservationValidator.validateUpdateReservationRequest(reservationBO);

		VisitorBookingData visitorBookingData = visitorBookingDataDAO
				.retrieveByConfirmationCode(reservationBO.getConfirmationCode());

		if (visitorBookingData == null) {
			throw new ApiGenericFieldValidationException(
					"Could not find the reservation. Please enter valid ConfirmationCode");
		}

		if (visitorBookingData.getStatus().equals(BookingStatus.Cancelled.toString())) {
			throw new ApiGenericFieldValidationException("This reservation has already been cancelled. Please rebook");
		}

		if (StringUtils.isNotBlank(reservationBO.getEmail())) {
			visitorBookingData.setEmail(reservationBO.getEmail());
		}

		if (StringUtils.isNotBlank(reservationBO.getFullName())) {
			visitorBookingData.setFullName(reservationBO.getFullName());
		}

		if (StringUtils.isNotBlank(reservationBO.getEmail()) || StringUtils.isNotBlank(reservationBO.getFullName())) {
			visitorBookingData.setUpdateDate(new Date());
			visitorBookingData.setUpdatedBy("Booking update API");
		}

		visitorBookingData = visitorBookingDataDAO.save(visitorBookingData);

		/*
		 * Creating the Reservation Respnse BO
		 */
		reservationBO = ReservationTransformer.transformReservationEntityToReservationBO(visitorBookingData,
				new ReservationBO());

		return reservationBO;
	}

	@Override
	public ReservationBO retrieveReservation(String confirmationCode) {

		ReservationValidator.validateCancelOrRetrieve(confirmationCode);

		VisitorBookingData booking = visitorBookingDataDAO.retrieveByConfirmationCode(confirmationCode);

		ReservationBO reservationBO = ReservationTransformer.transformReservationEntityToReservationBO(booking,
				new ReservationBO());

		return reservationBO;
	}

	@Override
	public void cancelReservation(String confirmationCode) {

		ReservationValidator.validateCancelOrRetrieve(confirmationCode);

		VisitorBookingData booking = visitorBookingDataDAO.retrieveByConfirmationCode(confirmationCode);

		if (booking == null) {
			throw new ApiGenericFieldValidationException(
					"Could not find the reservation. Please enter valid ConfirmationCode");
		}

		if (booking.getStatus().equals(BookingStatus.Cancelled.toString())) {
			throw new ApiGenericFieldValidationException("This reservation has already been cancelled");
		}

		/*
		 * Validating to check if checkout date is back dated.
		 */
		if (DateUtils.rangeBetweenDates(new Date(), booking.getBookedCheckOutDate()) < 1) {
			throw new ApiGenericFieldValidationException("Cannot cancel this reservation as this is back dated");
		}

		booking.setStatus(BookingStatus.Cancelled.toString());
		booking = visitorBookingDataDAO.save(booking);

		/*
		 * Subtracting with one day as we don't need to know reservations on the day of
		 * checkout
		 */
		Calendar c = Calendar.getInstance();
		c.setTime(booking.getBookedCheckOutDate());
		c.add(Calendar.DATE, -1);
		/*
		 * Retrieving availabilities and updating the number of availabilities for
		 * visitors
		 */
		List<Availability> availabilities = availabilityDAO.findByAvailableDateRange(booking.getBookedCheckInDate(),
				c.getTime());

		int numOfVisitors = booking.getNumberOfVisitors();
		/*
		 * Updating availabilities
		 */
		availabilities.stream().forEach(availability -> {
			availability.setBookedNumberOfVisitors(availability.getBookedNumberOfVisitors() - numOfVisitors);
			availability.setUpdateDate(new Date());
			availability.setUpdatedBy("Booking create API");
		});

		availabilityDAO.saveAll(availabilities);
	}

	/*
	 * Implementing synchronized method, as mentioned in the email from Taryn Olson
	 * , 'The main thing to keep in mind is that there can only be one reservation
	 * booked at a time'
	 */

	private synchronized VisitorBookingData validateAvailableDatesAndVisitorsAndSavingInDatabase(Date checkInDate, Date checkOutDate,
			ReservationBO reservationBO) {

		log.info("Initiated booking process for " + reservationBO.getFullName());

		/*
		 * Subtracting with one day as we dont need to know reservations on the day of
		 * checkout
		 */
		Calendar c1 = Calendar.getInstance();
		c1.setTime(checkOutDate);
		c1.add(Calendar.DATE, -1);
		List<Availability> availabilities = availabilityDAO.findByAvailableDateRange(checkInDate, c1.getTime());

		/*
		 * If none of the days are available
		 */
		if (CollectionUtils.isEmpty(availabilities)) {
			throw new ApiGenericFieldValidationException(
					"Not enough slots available for given dates. Please try again with different dates");
		}

		/*
		 * Creating a helper map
		 */
		Map<String, Availability> availabilityMap = new HashMap<String, Availability>();

		availabilities.stream()
				.forEach(availability -> availabilityMap.put(
						DateUtils.toString(DateFormat.standardDateFormat.getValue(), availability.getAvailableDate()),
						availability));

		long rangeInDays = DateUtils.rangeBetweenDates(checkInDate, checkOutDate);

		/*
		 * Looping each day and finding if booking can be done
		 */
		for (int i = 0; i <= rangeInDays - 1; i++) {
			Calendar c = Calendar.getInstance();
			c.setTime(checkInDate);
			c.add(Calendar.DATE, i);
			String validatingDate = DateUtils.toString(DateFormat.standardDateFormat.getValue(), c.getTime());

			if (availabilityMap.containsKey(validatingDate)) {
				Availability availability = availabilityMap.get(validatingDate);

				int numberOfReservationsAvailable = availability.getAllowedNumberOfVisitors()
						- availability.getBookedNumberOfVisitors();

				if (numberOfReservationsAvailable < reservationBO.getNumberOfVisitors()) {
					throw new ApiGenericFieldValidationException(
							"Not enough slots available for given dates. Please try again with different dates");
				}

			} else {
				throw new ApiGenericFieldValidationException(
						"Not enough slots available for given dates. Please try again with different dates");
			}
		}

		/*
		 * Transforming ReservationBO into VisitorBookingData
		 */
		VisitorBookingData visitorBookingData = ReservationTransformer.transformReservationBOToEntity(reservationBO,
				new VisitorBookingData());

		visitorBookingData = visitorBookingDataDAO.save(visitorBookingData);

		/*
		 * Updating availabilities
		 */
		availabilities.stream().forEach(availability -> {
			availability.setBookedNumberOfVisitors(
					availability.getBookedNumberOfVisitors() + reservationBO.getNumberOfVisitors());
			availability.setUpdateDate(new Date());
			availability.setUpdatedBy("Booking create API");
		});

		availabilityDAO.saveAll(availabilities);

		log.info("Completed booking process for " + reservationBO.getFullName());
		return visitorBookingData;

	}

}
