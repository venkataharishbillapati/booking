/*******************************************************************************
 * @author Harish Billapati
 *******************************************************************************/

package com.upgrade.booking.BO;

public class ReservationBO {

	private String checkInDate;
	private String checkOutDate;
	private String fullName;
	private String email;
	private Integer numberOfVisitors;
	private String confirmationCode;
	private String status;

	/**
	 * @return the checkInDate
	 */
	public String getCheckInDate() {
		return checkInDate;
	}

	/**
	 * @param checkInDate the checkInDate to set
	 */
	public void setCheckInDate(String checkInDate) {
		this.checkInDate = checkInDate;
	}

	/**
	 * @return the checkOutDate
	 */
	public String getCheckOutDate() {
		return checkOutDate;
	}

	/**
	 * @param checkOutDate the checkOutDate to set
	 */
	public void setCheckOutDate(String checkOutDate) {
		this.checkOutDate = checkOutDate;
	}

	/**
	 * @return the fullName
	 */
	public String getFullName() {
		return fullName;
	}

	/**
	 * @param fullName the fullName to set
	 */
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the numberOfVisitors
	 */
	public Integer getNumberOfVisitors() {
		return numberOfVisitors;
	}

	/**
	 * @param numberOfVisitors the numberOfVisitors to set
	 */
	public void setNumberOfVisitors(Integer numberOfVisitors) {
		this.numberOfVisitors = numberOfVisitors;
	}

	/**
	 * @return the confirmationCode
	 */
	public String getConfirmationCode() {
		return confirmationCode;
	}

	/**
	 * @param confirmationCode the confirmationCode to set
	 */
	public void setConfirmationCode(String confirmationCode) {
		this.confirmationCode = confirmationCode;
	}

	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}

}
