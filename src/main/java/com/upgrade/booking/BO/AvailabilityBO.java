/*******************************************************************************
 * @author Harish Billapati
 *******************************************************************************/

package com.upgrade.booking.BO;

import java.util.Date;

public class AvailabilityBO {

	private Date date;
	private Integer numberOfAvailableSlots;

	/**
	 * @return the date
	 */
	public Date getDate() {
		return date;
	}

	/**
	 * @param date the date to set
	 */
	public void setDate(Date date) {
		this.date = date;
	}

	/**
	 * @return the numberOfAvailableSlots
	 */
	public Integer getNumberOfAvailableSlots() {
		return numberOfAvailableSlots;
	}

	/**
	 * @param numberOfAvailableSlots the numberOfAvailableSlots to set
	 */
	public void setNumberOfAvailableSlots(Integer numberOfAvailableSlots) {
		this.numberOfAvailableSlots = numberOfAvailableSlots;
	}

}
