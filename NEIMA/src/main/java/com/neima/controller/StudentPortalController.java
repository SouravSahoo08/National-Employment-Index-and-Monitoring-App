package com.neima.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.neima.entity.AuthRequest;
import com.neima.services.JwtService;

@RestController
@RequestMapping("/student")
public class StudentPortalController {
	
	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
    private JwtService jwtService;
	
	@GetMapping("/data")
	@PreAuthorize("hasAuthority('ROLE_STUDENT')")
	public String view() {
		return "users";
	}

	/**
	 * This endpoint must be used before any other endpoint 
	 * to geenrate token.
	 * 
	 * @param authRequest
	 * @return Generated Token
	 */
	@PostMapping("/authenticate")
	public String authenticateAndGenerateToken(@RequestBody AuthRequest authRequest) {
		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword()));
		
		if(authentication.isAuthenticated()) {
			return jwtService.generateToken(authRequest.getUsername());
		}else {
			System.err.println("here");
			throw new UsernameNotFoundException("invalid Username");
		}
		
	}
}
