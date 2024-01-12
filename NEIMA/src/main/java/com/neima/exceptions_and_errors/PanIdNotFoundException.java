package com.neima.exceptions_and_errors;

public class PanIdNotFoundException extends RuntimeException {

	private String message;

	public PanIdNotFoundException() {
	}

	public PanIdNotFoundException(String message) {
		super(message);
		this.message = message;
		System.err.println(message);
	}

}
