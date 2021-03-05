/*******************************************************************************
 * @author Harish Billapati
 *******************************************************************************/

package com.upgrade.booking.exceptionhandling;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

import com.upgrade.booking.DTO.ErrorDTO;

@ControllerAdvice(annotations = RestController.class)
public class ApiControllerAdvice {

	private static final Logger log = LoggerFactory.getLogger(ApiControllerAdvice.class);

	@ExceptionHandler(value = ServletRequestBindingException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ResponseBody
	public ErrorDTO handleAllException(ServletRequestBindingException exception, WebRequest request) {
		log.error("Controller Advice Exception", exception);
		ErrorDTO error = new ErrorDTO();
		error.setStatus(Integer.toString(HttpStatus.BAD_REQUEST.value()));
		error.setMessage(exception.getLocalizedMessage());
		error.setTimestamp(new Date().toString());
		return error;
	}

	@ExceptionHandler(value = ApiGenericFieldValidationException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ResponseBody
	public ErrorDTO handleAllException(ApiGenericFieldValidationException exception, WebRequest request) {
		log.error("Controller Advice Exception", exception);
		ErrorDTO error = new ErrorDTO();
		error.setStatus(Integer.toString(HttpStatus.BAD_REQUEST.value()));
		error.setMessage(exception.getMessage());
		error.setTimestamp(new Date().toString());
		return error;
	}

	@ExceptionHandler(value = Exception.class)
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	@ResponseBody
	public ErrorDTO handleAllException(Exception exception, WebRequest request) {
		log.error("Controller Advice Exception", exception);
		ErrorDTO error = new ErrorDTO();
		error.setStatus(Integer.toString(HttpStatus.INTERNAL_SERVER_ERROR.value()));
		error.setMessage(exception.getLocalizedMessage());
		error.setTimestamp(new Date().toString());
		return error;
	}

	@ExceptionHandler(value = HttpMessageNotReadableException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ResponseBody
	public ErrorDTO handleException(HttpMessageNotReadableException exception, WebRequest request) {
		log.error("Bad Input", exception);
		ErrorDTO error = new ErrorDTO();
		error.setStatus(Integer.toString(HttpStatus.BAD_REQUEST.value()));
		error.setMessage(exception.getLocalizedMessage());
		error.setTimestamp(new Date().toString());
		return error;
	}

}
