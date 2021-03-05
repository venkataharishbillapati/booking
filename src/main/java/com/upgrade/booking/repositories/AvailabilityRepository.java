/*******************************************************************************
 * @author Harish Billapati
 *******************************************************************************/

package com.upgrade.booking.repositories;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.upgrade.booking.entities.Availability;

public interface AvailabilityRepository extends BaseRepository<Availability, Long>{

	
	@Query("select a from Availability a where a.availableDate between :checkInDate and :checkOutDate order by a.availableDate asc")
	public List<Availability> findByAvailableDateRange(@Param("checkInDate") Date checkInDate, @Param("checkOutDate") Date checkOutDate);

}
