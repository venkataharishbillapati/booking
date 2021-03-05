/*******************************************************************************
 * @author Harish Billapati
 *******************************************************************************/

package com.upgrade.booking.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.upgrade.booking.BO.AvailabilityBO;
import com.upgrade.booking.DTO.AvailablityDTO;
import com.upgrade.booking.service.AvailabilityService;
import com.upgrade.booking.transformers.AvailablityTransformer;

@RestController
@RequestMapping(value = "/V1")
public class AvailabilityController {

	@Autowired
	private AvailabilityService availabilityService;

	/*
	 * This api used to check the availability
	 */
	@RequestMapping(method = RequestMethod.GET, value = "/Availability")
	public List<AvailablityDTO> create(@RequestParam(value = "CheckInDate", required = false) String checkInDate,
			@RequestParam(value = "CheckOutDate", required = false) String checkOutDate) {

		List<AvailabilityBO> availabilityBOs = availabilityService.retrieveAvailability(checkInDate, checkOutDate);

		List<AvailablityDTO> availablityDTOs = AvailablityTransformer.transformAvailablityBOToDTO(availabilityBOs,
				new ArrayList<AvailablityDTO>());

		return availablityDTOs;
	}

}
