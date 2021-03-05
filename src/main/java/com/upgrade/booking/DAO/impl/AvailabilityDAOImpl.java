/*******************************************************************************
 * @author Harish Billapati
 *******************************************************************************/

package com.upgrade.booking.DAO.impl;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.upgrade.booking.DAO.AvailabilityDAO;
import com.upgrade.booking.entities.Availability;
import com.upgrade.booking.repositories.AvailabilityRepository;

@Repository
public class AvailabilityDAOImpl implements AvailabilityDAO {

	@Autowired
	private AvailabilityRepository availabilityRepository;

	@Override
	public List<Availability> findByAvailableDateRange(Date checkInDate, Date checkOutDate) {

		List<Availability> availabilities = availabilityRepository.findByAvailableDateRange(checkInDate, checkOutDate);

		return availabilities;
	}

	@Override
	@Transactional
	public List<Availability> saveAll(List<Availability> availabilities) {
		return availabilityRepository.saveAll(availabilities);
	}

}
