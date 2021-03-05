/*******************************************************************************
 * @author Harish Billapati
 *******************************************************************************/

package com.upgrade.booking.DTO;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "Date", "NumberOfAvailableSlots" })
public class AvailablityDTO {

	@JsonProperty("Date")
	private String date;
	@JsonProperty("NumberOfAvailableSlots")
	private Integer numberOfAvailableSlots;
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	@JsonProperty("Date")
	public String getDate() {
		return date;
	}

	@JsonProperty("Date")
	public void setDate(String date) {
		this.date = date;
	}

	@JsonProperty("NumberOfAvailableSlots")
	public Integer getNumberOfAvailableSlots() {
		return numberOfAvailableSlots;
	}

	@JsonProperty("NumberOfAvailableSlots")
	public void setNumberOfAvailableSlots(Integer numberOfAvailableSlots) {
		this.numberOfAvailableSlots = numberOfAvailableSlots;
	}

	@JsonAnyGetter
	public Map<String, Object> getAdditionalProperties() {
		return this.additionalProperties;
	}

	@JsonAnySetter
	public void setAdditionalProperty(String name, Object value) {
		this.additionalProperties.put(name, value);
	}

}