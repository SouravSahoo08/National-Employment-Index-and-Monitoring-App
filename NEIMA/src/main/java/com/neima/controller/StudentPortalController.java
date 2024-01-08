package com.neima.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/student")
public class StudentPortalController {
	
	@GetMapping("/data")
	@PreAuthorize("hasAuthority('ROLE_STUDENT')")
	public String view() {
		return "users";
	}

}
