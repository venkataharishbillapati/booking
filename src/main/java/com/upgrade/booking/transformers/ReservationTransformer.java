/*******************************************************************************
 * @author Harish Billapati
 *******************************************************************************/

package com.upgrade.booking.transformers;

import java.util.Date;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;

import com.upgrade.booking.BO.ReservationBO;
import com.upgrade.booking.DTO.ReservationDTO;
import com.upgrade.booking.constants.BookingStatus;
import com.upgrade.booking.constants.DateFormat;
import com.upgrade.booking.entities.VisitorBookingData;
import com.upgrade.booking.utils.DateUtils;

public class ReservationTransformer {

	public static ReservationBO transformReservationDTOToBO(ReservationDTO reservationRequestDTO,
			ReservationBO reservationBO) {

		if (StringUtils.isNotBlank(reservationRequestDTO.getCheckInDate())) {
			reservationBO.setCheckInDate(reservationRequestDTO.getCheckInDate());
		}

		if (StringUtils.isNotBlank(reservationRequestDTO.getCheckOutDate())) {
			reservationBO.setCheckOutDate(reservationRequestDTO.getCheckOutDate());
		}

		if (StringUtils.isNotBlank(reservationRequestDTO.getEmail())) {
			reservationBO.setEmail(reservationRequestDTO.getEmail());
		}

		if (StringUtils.isNotBlank(reservationRequestDTO.getFullName())) {
			reservationBO.setFullName(reservationRequestDTO.getFullName());
		}

		if (reservationRequestDTO.getNumberOfVisitors() != null) {
			reservationBO.setNumberOfVisitors(reservationRequestDTO.getNumberOfVisitors());
		}

		return reservationBO;
	}

	public static ReservationDTO transformReservationBOToDTO(ReservationBO reservationBO,
			ReservationDTO reservationResponseDTO) {

		if (StringUtils.isNotBlank(reservationBO.getCheckInDate())) {
			reservationResponseDTO.setCheckInDate(reservationBO.getCheckInDate());
		}

		if (StringUtils.isNotBlank(reservationBO.getCheckOutDate())) {
			reservationResponseDTO.setCheckOutDate(reservationBO.getCheckOutDate());
		}

		if (StringUtils.isNotBlank(reservationBO.getEmail())) {
			reservationResponseDTO.setEmail(reservationBO.getEmail());
		}

		if (StringUtils.isNotBlank(reservationBO.getFullName())) {
			reservationResponseDTO.setFullName(reservationBO.getFullName());
		}

		if (reservationBO.getNumberOfVisitors() != null) {
			reservationResponseDTO.setNumberOfVisitors(reservationBO.getNumberOfVisitors());
		}

		if (StringUtils.isNotBlank(reservationBO.getConfirmationCode())) {
			reservationResponseDTO.setConfirmationCode(reservationBO.getConfirmationCode());
		}
		
		if (StringUtils.isNotBlank(reservationBO.getStatus())) {
			reservationResponseDTO.setStatus(reservationBO.getStatus());
		}

		return reservationResponseDTO;
	}

	public static ReservationBO transformReservationEntityToReservationBO(VisitorBookingData visitorBookingData,
			ReservationBO reservationBO) {

		if (visitorBookingData != null) {

			if (visitorBookingData.getBookedCheckInDate() != null) {
				reservationBO.setCheckInDate(
						DateUtils.toString(DateFormat.standardDateFormat.getValue(), visitorBookingData.getBookedCheckInDate()));
			}

			if (visitorBookingData.getBookedCheckOutDate() != null) {
				reservationBO.setCheckOutDate(
						DateUtils.toString(DateFormat.standardDateFormat.getValue(), visitorBookingData.getBookedCheckOutDate()));
			}

			if (StringUtils.isNotBlank(visitorBookingData.getEmail())) {
				reservationBO.setEmail(visitorBookingData.getEmail());
			}

			if (StringUtils.isNotBlank(visitorBookingData.getFullName())) {
				reservationBO.setFullName(visitorBookingData.getFullName());
			}

			if (visitorBookingData.getNumberOfVisitors() != null) {
				reservationBO.setNumberOfVisitors(visitorBookingData.getNumberOfVisitors());
			}

			if (StringUtils.isNotBlank(visitorBookingData.getConfirmationCode())) {
				reservationBO.setConfirmationCode(visitorBookingData.getConfirmationCode());
			}

			if (StringUtils.isNotBlank(visitorBookingData.getStatus())) {
				reservationBO.setStatus(visitorBookingData.getStatus());
			}

		}

		return reservationBO;
	}

	public static VisitorBookingData transformReservationBOToEntity(ReservationBO reservationBO,
			VisitorBookingData visitorBookingData) {

		if (reservationBO != null) {

			if (reservationBO.getCheckInDate() != null) {
				visitorBookingData.setBookedCheckInDate(
						DateUtils.toDate(DateFormat.standardDateFormat.getValue(), reservationBO.getCheckInDate()));
			}

			if (reservationBO.getCheckOutDate() != null) {
				visitorBookingData.setBookedCheckOutDate(
						DateUtils.toDate(DateFormat.standardDateFormat.getValue(), reservationBO.getCheckOutDate()));
			}

			if (StringUtils.isNotBlank(reservationBO.getEmail())) {
				visitorBookingData.setEmail(reservationBO.getEmail());
			}

			if (StringUtils.isNotBlank(reservationBO.getFullName())) {
				visitorBookingData.setFullName(reservationBO.getFullName());
			}

			if (reservationBO.getNumberOfVisitors() != null) {
				visitorBookingData.setNumberOfVisitors(reservationBO.getNumberOfVisitors());
			}

			visitorBookingData.setConfirmationCode(RandomStringUtils.randomAlphanumeric(15).toUpperCase());

			visitorBookingData.setStatus(BookingStatus.Confirmed.toString());

			visitorBookingData.setCreateDate(new Date());
			visitorBookingData.setUpdateDate(new Date());
			visitorBookingData.setCreatedBy("Booking create API");
			visitorBookingData.setUpdatedBy("Booking create API");

		}

		return visitorBookingData;
	}

}
