/*******************************************************************************
 * @author Harish Billapati
 *******************************************************************************/

package com.upgrade.booking.DAO;

import com.upgrade.booking.entities.VisitorBookingData;

public interface VisitorBookingDataDAO {

	public VisitorBookingData retrieveByConfirmationCode(String confirmationCode);

	public VisitorBookingData save(VisitorBookingData visitorBookingData);

}
