/*******************************************************************************
 * @author Harish Billapati
 *******************************************************************************/

package com.upgrade.booking.DAO.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.upgrade.booking.DAO.VisitorBookingDataDAO;
import com.upgrade.booking.entities.VisitorBookingData;
import com.upgrade.booking.repositories.VisitorBookingDataRepository;

@Repository
public class VisitorBookingDataDAOImpl implements VisitorBookingDataDAO {

	@Autowired
	private VisitorBookingDataRepository visitorBookingDataRepository;

	@Override
	public VisitorBookingData retrieveByConfirmationCode(String confirmationCode) {
		return visitorBookingDataRepository.findByConfirmationCode(confirmationCode);
	}

	@Override
	@Transactional
	public VisitorBookingData save(VisitorBookingData visitorBookingData) {
		return  visitorBookingDataRepository.save(visitorBookingData);
	}

}
