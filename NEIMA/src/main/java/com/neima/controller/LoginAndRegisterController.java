package com.neima.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.neima.entity.CompanyInfo;
import com.neima.entity.StudentInfo;
import com.neima.services.CompanyDetailsService;
import com.neima.services.StudentDetailsService;

@RestController
@RequestMapping("/home")
public class LoginAndRegisterController {

	@Autowired
	private CompanyDetailsService companyDetailsService;
	@Autowired
	private StudentDetailsService studentDetailsService;

	// data for public display (permit all) - get

	// Register new company (permit all) - post
	@PostMapping("/register-company")
	public CompanyInfo registerNewCompany(@RequestBody CompanyInfo companyInfo) {
		return companyDetailsService.saveCompanyDetails(companyInfo);
	}

	// Register new student (permit all) - post
	@PostMapping("/register-student")
	public StudentInfo registerNewStudent(@RequestBody StudentInfo studentInfo) {
		return studentDetailsService.saveStudentDetails(studentInfo);
	}

}
