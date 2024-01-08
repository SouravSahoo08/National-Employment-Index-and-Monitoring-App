package com.neima.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.neima.entity.CompanyInfo;
import com.neima.services.CompanyDetailsService;

@RestController
@RequestMapping("/company")
public class CompanyPortalController {
	
	@Autowired
	private CompanyDetailsService companyDetailsService;
	
	@GetMapping("/data")
	@ResponseBody
	//@PreAuthorize("hasAuthority('ROLE_COMPANY')")
	@Cacheable(value = "companyInfos")
	public List<CompanyInfo> view() {
		return companyDetailsService.getAllCompanies();
	}
	
	@GetMapping("/data/{companyId}")
	@ResponseBody
	public CompanyInfo viewOne(@PathVariable int companyId) {
		return companyDetailsService.getCompany(companyId).get();
	}

}
