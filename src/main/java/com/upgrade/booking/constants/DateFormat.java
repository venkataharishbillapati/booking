/*******************************************************************************
 * @author Harish Billapati
 *******************************************************************************/

package com.upgrade.booking.constants;

public enum DateFormat {

	standardDateFormat("yyyy-MM-dd"), standardDateTimeFormat("yyyy-MM-dd'T'HH:mm:ss");

	public String value;

	private DateFormat(String value) {
		this.value = value;
	}

	/**
	 * @return the value
	 */
	public String getValue() {
		return value;
	}

}
