package com.neima.exceptions_and_errors;

public class PanIdAlreadyExistsException extends RuntimeException {

	private static final long serialVersionUID = -9092173454688884126L;
	private String message;

	public PanIdAlreadyExistsException() {
	}

	public PanIdAlreadyExistsException(String message) {
		super(message);
		this.message = message;
		System.err.println(message);
	}

}
