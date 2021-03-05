/*******************************************************************************
 * @author Harish Billapati
 *******************************************************************************/

package com.upgrade.booking.validator;

import org.apache.commons.lang3.StringUtils;

import com.upgrade.booking.constants.DateFormat;
import com.upgrade.booking.exceptionhandling.ApiGenericFieldValidationException;
import com.upgrade.booking.utils.DateUtils;

public class AvailabilityValidator {

	public static void validateAvailabilityRetrieveRequest(String checkInDate, String checkOutDate) {

		if (StringUtils.isNotBlank(checkInDate) && !DateUtils.isValidFormat(DateFormat.standardDateFormat.getValue(), checkInDate)) {
			throw new ApiGenericFieldValidationException(
					"Invalid CheckInDate format. Allowed format is " + DateFormat.standardDateFormat.getValue());
		}

		if (StringUtils.isNotBlank(checkOutDate) && !DateUtils.isValidFormat(DateFormat.standardDateFormat.getValue(), checkOutDate)) {
			throw new ApiGenericFieldValidationException(
					"Invalid CheckOutDate format. Allowed format is " + DateFormat.standardDateFormat.getValue());
		}
	}

}
