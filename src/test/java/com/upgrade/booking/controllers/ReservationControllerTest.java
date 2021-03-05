/*******************************************************************************
 * @author Harish Billapati
 *******************************************************************************/

package com.upgrade.booking.controllers;

import static org.junit.Assert.assertEquals;

import java.util.Calendar;
import java.util.concurrent.CompletableFuture;
import java.util.function.Supplier;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;

import com.upgrade.booking.DTO.ReservationDTO;
import com.upgrade.booking.constants.DateFormat;
import com.upgrade.booking.utils.DateUtils;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@TestPropertySource("classpath:test.properties")
@Sql(scripts = { "classpath:insertStatements.sql" })
public class ReservationControllerTest {

	/*
	 * Please create the Database, schema and tables using the SQL places in
	 * README.md file
	 */

	@LocalServerPort
	private int port;

	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	public void create() throws Exception {

		Calendar c = Calendar.getInstance();
		c.add(Calendar.DATE, 1);

		String checkInDate = DateUtils.toString(DateFormat.standardDateFormat.getValue(), c.getTime());

		c.add(Calendar.DATE, 2);
		String checkOutDate = DateUtils.toString(DateFormat.standardDateFormat.getValue(), c.getTime());

		/*
		 * Creating 3 requests and booking the tickets simultaneously from tomorrow
		 * (which has only 10 seats available) to next 3 days and calling the calling
		 * the reserve API asynchronously
		 */

		ReservationDTO requestDTO1 = new ReservationDTO();
		requestDTO1.setCheckInDate(checkInDate);
		requestDTO1.setCheckOutDate(checkOutDate);
		requestDTO1.setEmail("abc@gmail.com");
		requestDTO1.setFullName("Harish Billapati");
		requestDTO1.setNumberOfVisitors(4);

		ReservationDTO requestDTO2 = new ReservationDTO();
		requestDTO2.setCheckInDate(checkInDate);
		requestDTO2.setCheckOutDate(checkOutDate);
		requestDTO2.setEmail("def@gmail.com");
		requestDTO2.setFullName("Harry Potter");
		requestDTO2.setNumberOfVisitors(6);

		ReservationDTO requestDTO3 = new ReservationDTO();
		requestDTO3.setCheckInDate(checkInDate);
		requestDTO3.setCheckOutDate(checkOutDate);
		requestDTO3.setEmail("ghi@gmail.com");
		requestDTO3.setFullName("Emma Wastson");
		requestDTO3.setNumberOfVisitors(2);

		CompletableFuture<ResponseEntity<ReservationDTO>> response1ResponseEntity = invokeResevationCreate(requestDTO1,
				restTemplate);
		CompletableFuture<ResponseEntity<ReservationDTO>> response2ResponseEntity = invokeResevationCreate(requestDTO2,
				restTemplate);
		CompletableFuture<ResponseEntity<ReservationDTO>> response3ResponseEntity = invokeResevationCreate(requestDTO3,
				restTemplate);

		/*
		 * In Init statement, we have only 10 visitors available for tomorrow, so
		 * Expected result should be one of the response cannot create reservation due
		 * to 'Not enough slots available for given dates. Please try again with
		 * different dates' and other 2 records are Confirmed
		 */

		int successCount = 0;
		int failureCount = 0;

		if (response1ResponseEntity.get().getStatusCode().is2xxSuccessful()) {
			successCount++;
		} else {
			failureCount++;
		}

		if (response2ResponseEntity.get().getStatusCode().is2xxSuccessful()) {
			successCount++;
		} else {
			failureCount++;
		}

		if (response3ResponseEntity.get().getStatusCode().is2xxSuccessful()) {
			successCount++;
		} else {
			failureCount++;
		}

		// As expected, we will get 2 success and 1 failure
		assertEquals(2, successCount);
		assertEquals(1, failureCount);
	}

	/*
	 * Utility method to invoke the API asynchronously. Using Completable Future
	 */
	public CompletableFuture<ResponseEntity<ReservationDTO>> invokeResevationCreate(ReservationDTO requestDTO,
			TestRestTemplate restTemplate2) {

		CompletableFuture<ResponseEntity<ReservationDTO>> future = CompletableFuture
				.supplyAsync(new Supplier<ResponseEntity<ReservationDTO>>() {
					@Override
					public ResponseEntity<ReservationDTO> get() {
						return restTemplate2.postForEntity("http://localhost:" + port + "/V1/Reserve", requestDTO,
								ReservationDTO.class);
					}
				});
		return future;
	}

}
