package com.neima.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Model class to hold credentials from incoming request
 * for token generation.
 *
 * @author jacky
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AuthRequest {
	private String username;
	private String password;
}
