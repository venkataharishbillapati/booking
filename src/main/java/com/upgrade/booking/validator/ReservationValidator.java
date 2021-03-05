/*******************************************************************************
 * @author Harish Billapati
 *******************************************************************************/

package com.upgrade.booking.validator;

import java.util.Calendar;
import java.util.Date;

import org.apache.commons.lang3.StringUtils;

import com.upgrade.booking.BO.ReservationBO;
import com.upgrade.booking.constants.DateFormat;
import com.upgrade.booking.exceptionhandling.ApiGenericFieldValidationException;
import com.upgrade.booking.utils.DateUtils;

public class ReservationValidator {

	public static void validateCreateReservationRequest(ReservationBO reservationBO) {

		if (StringUtils.isBlank(reservationBO.getCheckInDate())
				|| !DateUtils.isValidFormat(DateFormat.standardDateFormat.getValue(), reservationBO.getCheckInDate())) {
			throw new ApiGenericFieldValidationException(
					"CheckInDate is required and allowed format is " + DateFormat.standardDateFormat.getValue());
		}

		if (StringUtils.isBlank(reservationBO.getCheckOutDate()) || !DateUtils
				.isValidFormat(DateFormat.standardDateFormat.getValue(), reservationBO.getCheckOutDate())) {
			throw new ApiGenericFieldValidationException(
					"CheckOutDate is required and allowed format is " + DateFormat.standardDateFormat.getValue());
		}

		/*
		 * Validating if CheckInDate is today or in future
		 */
		Date checkInDate = DateUtils.toDate(DateFormat.standardDateFormat.getValue(), reservationBO.getCheckInDate());
		Date checkOutDate = DateUtils.toDate(DateFormat.standardDateFormat.getValue(), reservationBO.getCheckOutDate());
		if (DateUtils.isDateInPast(checkInDate)) {
			throw new ApiGenericFieldValidationException(
					"The campsite can be reserved minimum 1 day(s) ahead of arrival");
		}

		/*
		 * Validating if CheckOutDate is not after a month
		 */
		Calendar c = Calendar.getInstance();
		c.add(Calendar.MONTH, 1);
		Date compareDate = c.getTime();
		if (compareDate.compareTo(checkOutDate) < 0) {
			throw new ApiGenericFieldValidationException("You can book only in advance of 1 month");
		}

		if (StringUtils.isBlank(reservationBO.getEmail())) {
			throw new ApiGenericFieldValidationException("Email is required");
		}

		if (StringUtils.isBlank(reservationBO.getFullName())) {
			throw new ApiGenericFieldValidationException("FullName is required");
		}

		if (reservationBO.getNumberOfVisitors() == null || reservationBO.getNumberOfVisitors() < 1) {
			throw new ApiGenericFieldValidationException("NumberOfVisitors is required and should be minimum 1");
		}

		long rangeBetweenDays = DateUtils.rangeBetweenDates(checkInDate, checkOutDate);

		if (rangeBetweenDays < 1 || rangeBetweenDays > 3) {
			throw new ApiGenericFieldValidationException(
					"The campsite can be reserved for minimum of 1 day and maximum of 3 days");
		}

	}

	public static void validateUpdateReservationRequest(ReservationBO reservationBO) {

		if (StringUtils.isNotBlank(reservationBO.getCheckInDate())
				|| StringUtils.isNotBlank(reservationBO.getCheckOutDate())
				|| reservationBO.getNumberOfVisitors() != null) {
			throw new ApiGenericFieldValidationException(
					"You can only update FullName or Email. For changing any other information, please cancel and rebook");
		}

	}

	public static void validateCancelOrRetrieve(String confirmationCode) {
		if (StringUtils.isBlank(confirmationCode)) {
			throw new ApiGenericFieldValidationException("ConfirmationCode is required");
		}
	}

}
