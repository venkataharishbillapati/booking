/*******************************************************************************
 * @author Harish Billapati
 *******************************************************************************/

package com.upgrade.booking.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.upgrade.booking.BO.ReservationBO;
import com.upgrade.booking.DTO.ReservationDTO;
import com.upgrade.booking.service.ReservationService;
import com.upgrade.booking.transformers.ReservationTransformer;

@RestController
@RequestMapping(value = "/V1")
public class ReservationController {

	@Autowired
	private ReservationService reservationService;

	@RequestMapping(method = RequestMethod.POST, value = "/Reserve")
	public ReservationDTO create(@RequestBody ReservationDTO requestDTO) {

		ReservationBO reservationBO = ReservationTransformer.transformReservationDTOToBO(requestDTO,
				new ReservationBO());

		reservationBO = reservationService.bookReservation(reservationBO);

		ReservationDTO reservationResponseDTO = new ReservationDTO();
		ReservationTransformer.transformReservationBOToDTO(reservationBO, reservationResponseDTO);

		return reservationResponseDTO;
	}

	@RequestMapping(method = RequestMethod.GET, value = "/Reserve/{ConfirmationCode}")
	public ReservationDTO retrieve(@PathVariable("ConfirmationCode") String confirmationCode) {

		ReservationBO reservationBO = reservationService.retrieveReservation(confirmationCode);

		ReservationDTO reservationResponseDTO = new ReservationDTO();
		ReservationTransformer.transformReservationBOToDTO(reservationBO, reservationResponseDTO);

		return reservationResponseDTO;
	}

	@RequestMapping(method = RequestMethod.PATCH, value = "/Reserve/{ConfirmationCode}")
	public ReservationDTO update(@PathVariable("ConfirmationCode") String confirmationCode,
			@RequestBody ReservationDTO reservationRequestDTO) {

		ReservationBO reservationBO = ReservationTransformer.transformReservationDTOToBO(reservationRequestDTO,
				new ReservationBO());
		reservationBO.setConfirmationCode(confirmationCode);
		reservationBO = reservationService.updateReservation(reservationBO);

		ReservationDTO reservationResponseDTO = new ReservationDTO();
		ReservationTransformer.transformReservationBOToDTO(reservationBO, reservationResponseDTO);

		return reservationResponseDTO;
	}

	@RequestMapping(method = RequestMethod.PATCH, value = "/Reserve/{ConfirmationCode}/Cancel")
	public String Cancel(@PathVariable("ConfirmationCode") String confirmationCode) {

		reservationService.cancelReservation(confirmationCode);
		return "Cancellation has been successful";
	}
}
