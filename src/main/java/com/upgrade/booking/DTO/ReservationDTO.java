/*******************************************************************************
 * @author Harish Billapati
 *******************************************************************************/

package com.upgrade.booking.DTO;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "CheckInDate", "CheckOutDate", "FullName", "Email", "NumberOfVisitors", "ConfirmationCode", "Status" })
public class ReservationDTO {

	@JsonProperty("CheckInDate")
	private String checkInDate;
	@JsonProperty("CheckOutDate")
	private String checkOutDate;
	@JsonProperty("FullName")
	private String fullName;
	@JsonProperty("Email")
	private String email;
	@JsonProperty("NumberOfVisitors")
	private Integer numberOfVisitors;
	@JsonProperty("ConfirmationCode")
	private String confirmationCode;
	@JsonProperty("Status")
	private String Status;

	@JsonProperty("CheckInDate")
	public String getCheckInDate() {
		return checkInDate;
	}

	@JsonProperty("CheckInDate")
	public void setCheckInDate(String checkInDate) {
		this.checkInDate = checkInDate;
	}

	@JsonProperty("CheckOutDate")
	public String getCheckOutDate() {
		return checkOutDate;
	}

	@JsonProperty("CheckOutDate")
	public void setCheckOutDate(String checkOutDate) {
		this.checkOutDate = checkOutDate;
	}

	@JsonProperty("FullName")
	public String getFullName() {
		return fullName;
	}

	@JsonProperty("FullName")
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	@JsonProperty("Email")
	public String getEmail() {
		return email;
	}

	@JsonProperty("Email")
	public void setEmail(String email) {
		this.email = email;
	}

	@JsonProperty("NumberOfVisitors")
	public Integer getNumberOfVisitors() {
		return numberOfVisitors;
	}

	@JsonProperty("NumberOfVisitors")
	public void setNumberOfVisitors(Integer numberOfVisitors) {
		this.numberOfVisitors = numberOfVisitors;
	}

	@JsonProperty("ConfirmationCode")
	public String getConfirmationCode() {
		return confirmationCode;
	}

	@JsonProperty("ConfirmationCode")
	public void setConfirmationCode(String confirmationCode) {
		this.confirmationCode = confirmationCode;
	}

	@JsonProperty("Status")
	public String getStatus() {
		return Status;
	}

	@JsonProperty("Status")
	public void setStatus(String status) {
		Status = status;
	}
	
	

}