/*******************************************************************************
 * @author Harish Billapati
 *******************************************************************************/

package com.upgrade.booking.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(catalog = "Upgrade", name = "VisitorBookingData", schema = "Booking")
public class VisitorBookingData implements java.io.Serializable {

	private static final long serialVersionUID = 1585648737760857366L;

	@Id
	@Column(name = "Id", unique = true, nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "FullName")
	private String fullName;

	@Column(name = "Email")
	private String email;

	@Temporal(TemporalType.DATE)
	@Column(name = "BookedCheckInDate")
	private Date bookedCheckInDate;

	@Temporal(TemporalType.DATE)
	@Column(name = "BookedCheckOutDate")
	private Date bookedCheckOutDate;

	@Column(name = "NumberOfVisitors")
	private Integer numberOfVisitors;

	@Column(name = "ConfirmationCode")
	private String confirmationCode;

	@Column(name = "Status")
	private String status;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "CreateDate")
	private Date CreateDate;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "UpdateDate")
	private Date UpdateDate;

	@Column(name = "CreatedBy")
	private String CreatedBy;

	@Column(name = "UpdatedBy")
	private String UpdatedBy;

	public VisitorBookingData() {
	}

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
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
	 * @return the bookedCheckInDate
	 */
	public Date getBookedCheckInDate() {
		return bookedCheckInDate;
	}

	/**
	 * @param bookedCheckInDate the bookedCheckInDate to set
	 */
	public void setBookedCheckInDate(Date bookedCheckInDate) {
		this.bookedCheckInDate = bookedCheckInDate;
	}

	/**
	 * @return the bookedCheckOutDate
	 */
	public Date getBookedCheckOutDate() {
		return bookedCheckOutDate;
	}

	/**
	 * @param bookedCheckOutDate the bookedCheckOutDate to set
	 */
	public void setBookedCheckOutDate(Date bookedCheckOutDate) {
		this.bookedCheckOutDate = bookedCheckOutDate;
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

	/**
	 * @return the createDate
	 */
	public Date getCreateDate() {
		return CreateDate;
	}

	/**
	 * @param createDate the createDate to set
	 */
	public void setCreateDate(Date createDate) {
		CreateDate = createDate;
	}

	/**
	 * @return the updateDate
	 */
	public Date getUpdateDate() {
		return UpdateDate;
	}

	/**
	 * @param updateDate the updateDate to set
	 */
	public void setUpdateDate(Date updateDate) {
		UpdateDate = updateDate;
	}

	/**
	 * @return the createdBy
	 */
	public String getCreatedBy() {
		return CreatedBy;
	}

	/**
	 * @param createdBy the createdBy to set
	 */
	public void setCreatedBy(String createdBy) {
		CreatedBy = createdBy;
	}

	/**
	 * @return the updatedBy
	 */
	public String getUpdatedBy() {
		return UpdatedBy;
	}

	/**
	 * @param updatedBy the updatedBy to set
	 */
	public void setUpdatedBy(String updatedBy) {
		UpdatedBy = updatedBy;
	}

}
