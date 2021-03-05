/*******************************************************************************
 * @author Harish Billapati
 *******************************************************************************/

package com.upgrade.booking.DAO;

import java.util.Date;
import java.util.List;

import com.upgrade.booking.entities.Availability;

public interface AvailabilityDAO {

	public List<Availability> findByAvailableDateRange(Date checkInDate, Date checkOutDate);

	public List<Availability> saveAll(List<Availability> availabilities);

}
