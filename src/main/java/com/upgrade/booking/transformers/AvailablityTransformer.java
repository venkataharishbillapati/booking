/*******************************************************************************
 * @author Harish Billapati
 *******************************************************************************/

package com.upgrade.booking.transformers;

import java.util.List;

import com.upgrade.booking.BO.AvailabilityBO;
import com.upgrade.booking.DTO.AvailablityDTO;
import com.upgrade.booking.constants.DateFormat;
import com.upgrade.booking.entities.Availability;
import com.upgrade.booking.utils.DateUtils;

public class AvailablityTransformer {

	public static List<AvailablityDTO> transformAvailablityBOToDTO(List<AvailabilityBO> availabilityBOs,
			List<AvailablityDTO> availablityDTOs) {

		for (AvailabilityBO availabilityBO : availabilityBOs) {

			AvailablityDTO availablityDTO = new AvailablityDTO();

			if (availabilityBO.getDate() != null) {
				availablityDTO.setDate(
						DateUtils.toString(DateFormat.standardDateFormat.getValue(), availabilityBO.getDate()));
			}

			if (availabilityBO.getNumberOfAvailableSlots() != null) {
				availablityDTO.setNumberOfAvailableSlots(availabilityBO.getNumberOfAvailableSlots());
			} 

			availablityDTOs.add(availablityDTO);

		}

		return availablityDTOs;
	}

	public static List<AvailabilityBO> transformAvailablityEntityToBO(List<Availability> availablities,
			List<AvailabilityBO> availabilityBOs) {

		for (Availability availability : availablities) {

			AvailabilityBO availabilityBO = new AvailabilityBO();

			if (availability.getAvailableDate() != null) {
				availabilityBO.setDate(availability.getAvailableDate());
			}

			if (availability.getAllowedNumberOfVisitors() != null && availability.getBookedNumberOfVisitors() != null) {
				availabilityBO.setNumberOfAvailableSlots(
						availability.getAllowedNumberOfVisitors() - availability.getBookedNumberOfVisitors());
			}

			availabilityBOs.add(availabilityBO);
		}

		return availabilityBOs;
	}

}
