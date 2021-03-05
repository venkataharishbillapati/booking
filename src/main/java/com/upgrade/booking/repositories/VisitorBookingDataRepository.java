/*******************************************************************************
 * @author Harish Billapati
 *******************************************************************************/

package com.upgrade.booking.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.upgrade.booking.entities.VisitorBookingData;

public interface VisitorBookingDataRepository extends BaseRepository<VisitorBookingData, Long>{

	@Query("select b from VisitorBookingData b where b.confirmationCode = :confirmationCode")
	public VisitorBookingData findByConfirmationCode(@Param("confirmationCode") String confirmationCode);

}
