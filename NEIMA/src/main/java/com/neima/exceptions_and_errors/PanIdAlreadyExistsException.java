package com.neima.exceptions_and_errors;

public class PanIdAlreadyExistsException extends RuntimeException {

	private String message;

	public PanIdAlreadyExistsException() {
	}

	public PanIdAlreadyExistsException(String message) {
		super(message);
		this.message = message;
		System.err.println(message);
	}

}
