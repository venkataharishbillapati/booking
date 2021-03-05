/*******************************************************************************
 * @author Harish Billapati
 *******************************************************************************/

package com.upgrade.booking.service;

import com.upgrade.booking.BO.ReservationBO;

public interface ReservationService {

	public ReservationBO bookReservation(ReservationBO reservationBO);
	
	public ReservationBO updateReservation(ReservationBO reservationBO);
	
	public ReservationBO retrieveReservation(String confirmationCode);
	
	public void cancelReservation(String confirmationCode);
	
}
