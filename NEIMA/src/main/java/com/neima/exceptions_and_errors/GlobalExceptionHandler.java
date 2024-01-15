package com.neima.exceptions_and_errors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
	@ExceptionHandler(value = PanIdAlreadyExistsException.class)
	public ResponseEntity<Object> handlePanIdAlreadyExistsException(PanIdAlreadyExistsException exception) {
		return ResponseEntity
                .status(HttpStatus.CONFLICT)
                .body(exception.getMessage());
	}
}
