/*******************************************************************************
 * @author Harish Billapati
 *******************************************************************************/

package com.upgrade.booking.service;

import java.util.List;

import com.upgrade.booking.BO.AvailabilityBO;

public interface AvailabilityService {

	public List<AvailabilityBO> retrieveAvailability(String checkInDate, String checkOutDate);
	
}
