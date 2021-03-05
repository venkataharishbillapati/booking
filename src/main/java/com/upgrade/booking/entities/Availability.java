/*******************************************************************************
 * @author Harish Billapati
 *******************************************************************************/

package com.upgrade.booking.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(catalog = "Upgrade", name = "Availability", schema = "Booking")

public class Availability implements Serializable {
	private static final long serialVersionUID = -4809680971216694316L;

	@Id
	@Column(name = "Id", unique = true, nullable = false)
	private Long id;

	@Temporal(TemporalType.DATE)
	@Column(name = "AvailableDate")
	private Date availableDate;

	@Column(name = "AllowedNumberOfVisitors")
	private Integer allowedNumberOfVisitors;

	@Column(name = "BookedNumberOfVisitors")
	private Integer bookedNumberOfVisitors;

	@Column(name = "CreatedBy")
	private String createdBy;

	@Column(name = "UpdatedBy")
	private String updatedBy;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "CreateDate")
	private Date createDate;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "UpdateDate")
	private Date updateDate;

	public Availability() {
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
	 * @return the availableDate
	 */
	public Date getAvailableDate() {
		return availableDate;
	}

	/**
	 * @param availableDate the availableDate to set
	 */
	public void setAvailableDate(Date availableDate) {
		this.availableDate = availableDate;
	}

	/**
	 * @return the allowedNumberOfVisitors
	 */
	public Integer getAllowedNumberOfVisitors() {
		return allowedNumberOfVisitors;
	}

	/**
	 * @param allowedNumberOfVisitors the allowedNumberOfVisitors to set
	 */
	public void setAllowedNumberOfVisitors(Integer allowedNumberOfVisitors) {
		this.allowedNumberOfVisitors = allowedNumberOfVisitors;
	}

	/**
	 * @return the bookedNumberOfVisitors
	 */
	public Integer getBookedNumberOfVisitors() {
		return bookedNumberOfVisitors;
	}

	/**
	 * @param bookedNumberOfVisitors the bookedNumberOfVisitors to set
	 */
	public void setBookedNumberOfVisitors(Integer bookedNumberOfVisitors) {
		this.bookedNumberOfVisitors = bookedNumberOfVisitors;
	}

	/**
	 * @return the createdBy
	 */
	public String getCreatedBy() {
		return createdBy;
	}

	/**
	 * @param createdBy the createdBy to set
	 */
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	/**
	 * @return the updatedBy
	 */
	public String getUpdatedBy() {
		return updatedBy;
	}

	/**
	 * @param updatedBy the updatedBy to set
	 */
	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	/**
	 * @return the createDate
	 */
	public Date getCreateDate() {
		return createDate;
	}

	/**
	 * @param createDate the createDate to set
	 */
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	/**
	 * @return the updateDate
	 */
	public Date getUpdateDate() {
		return updateDate;
	}

	/**
	 * @param updateDate the updateDate to set
	 */
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

}