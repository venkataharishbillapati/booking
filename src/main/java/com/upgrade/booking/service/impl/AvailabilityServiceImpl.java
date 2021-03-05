/*******************************************************************************
 * @author Harish Billapati
 *******************************************************************************/

package com.upgrade.booking.service.impl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.upgrade.booking.BO.AvailabilityBO;
import com.upgrade.booking.DAO.AvailabilityDAO;
import com.upgrade.booking.constants.DateFormat;
import com.upgrade.booking.entities.Availability;
import com.upgrade.booking.service.AvailabilityService;
import com.upgrade.booking.transformers.AvailablityTransformer;
import com.upgrade.booking.utils.DateUtils;
import com.upgrade.booking.validator.AvailabilityValidator;

@Service
public class AvailabilityServiceImpl implements AvailabilityService {

	@Autowired
	private AvailabilityDAO availabilityDAO;

	@Override
	public List<AvailabilityBO> retrieveAvailability(String checkInDate, String checkOutDate) {

		AvailabilityValidator.validateAvailabilityRetrieveRequest(checkInDate, checkOutDate);

		Date checkInDateConverted = null;
		if (checkInDate != null) {
			checkInDateConverted = DateUtils.toDate(DateFormat.standardDateFormat.getValue(), checkInDate);
		} else {
			checkInDateConverted = new Date();
		}

		Date checkOutDateConverted = null;
		if (checkOutDate != null) {
			checkOutDateConverted = DateUtils.toDate(DateFormat.standardDateFormat.getValue(), checkOutDate);
		} else {
			Calendar c = Calendar.getInstance();
			c.add(Calendar.MONTH, 1);
			checkOutDateConverted = c.getTime();
		}

		List<Availability> availabilities = availabilityDAO.findByAvailableDateRange(checkInDateConverted,
				checkOutDateConverted);

		List<AvailabilityBO> availabilityBOs = AvailablityTransformer.transformAvailablityEntityToBO(availabilities,
				new ArrayList<AvailabilityBO>());

		return availabilityBOs;
	}

}
