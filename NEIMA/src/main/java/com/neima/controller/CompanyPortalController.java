package com.neima.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.neima.entity.AuthRequest;
import com.neima.entity.CompanyInfo;
import com.neima.services.CompanyDetailsService;
import com.neima.services.JwtService;

@RestController
@RequestMapping("/company")
public class CompanyPortalController {

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
    private JwtService jwtService;
	
	@Autowired
	private CompanyDetailsService companyDetailsService;
	
	@GetMapping("/data")
	@ResponseBody
	//@Cacheable(value = "companyInfos")
	public List<CompanyInfo> view() {
		return companyDetailsService.getAllCompanies();
	}
	
	@GetMapping("/data/{companyId}")
	@ResponseBody
	public CompanyInfo viewOne(@PathVariable int companyId) {
		return companyDetailsService.getCompany(companyId).get();
	}

	/**
	 * This endpoint must be used before any other endpoint 
	 * to generate token.
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
