/*******************************************************************************
 * @author Harish Billapati
 *******************************************************************************/

package com.upgrade.booking.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class DateUtils {

	public static Date toDate(String format, String dateInString) {
		if (isValidFormat(format, dateInString)) {
			SimpleDateFormat formatter = new SimpleDateFormat(format);
			Date date = null;
			try {
				date = formatter.parse(dateInString);
			} catch (ParseException e) {
				e.printStackTrace();
			}
			return date;
		} else {
			throw new RuntimeException("invalid date format");
		}

	}

	public static String toString(String format, Date date) {
		String dateString = null;
		SimpleDateFormat sdfr = new SimpleDateFormat(format);
		try {
			dateString = sdfr.format(date);
		} catch (Exception ex) {
			System.out.println(ex);
		}
		return dateString;
	}

	public static boolean isValidFormat(String format, String value) {
		Date date = null;
		try {
			SimpleDateFormat sdf = new SimpleDateFormat(format);
			date = sdf.parse(value);
			if (!value.equals(sdf.format(date))) {
				date = null;
			}
		} catch (ParseException ex) {
			ex.printStackTrace();
		}
		return date != null;
	}

	public static long rangeBetweenDates(Date startDate, Date endDate) {
		long range = endDate.getTime() - startDate.getTime();
		long rangeInDays = TimeUnit.DAYS.convert(range, TimeUnit.MILLISECONDS);
		return rangeInDays;
	}
	
	public static boolean isSameDay(Date date1, Date date2) {
		return org.apache.commons.lang3.time.DateUtils.isSameDay(date1, date2);
	}
	
	public static boolean isDateInPast(Date date) {
		Date todaysDate = new Date();
		Calendar calendarToday = Calendar.getInstance();
		calendarToday.setTime(todaysDate);
		Calendar calendarInput = Calendar.getInstance();
		calendarInput.setTime(date);
		int compareFlag = calendarInput.getTime().compareTo(calendarToday.getTime());
		return (compareFlag < 0);
	}
	
}
