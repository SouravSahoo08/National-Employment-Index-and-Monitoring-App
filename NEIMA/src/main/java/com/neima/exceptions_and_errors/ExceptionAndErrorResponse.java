package com.neima.exceptions_and_errors;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ExceptionAndErrorResponse {

	private int statusCode;
	private String message;

}
