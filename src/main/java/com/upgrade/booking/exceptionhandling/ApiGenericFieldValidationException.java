/*******************************************************************************
 * @author Harish Billapati
 *******************************************************************************/

package com.upgrade.booking.exceptionhandling;

public class ApiGenericFieldValidationException extends RuntimeException {

	private static final long serialVersionUID = 1738164059303921769L;
	
	private String message;

	public ApiGenericFieldValidationException(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
