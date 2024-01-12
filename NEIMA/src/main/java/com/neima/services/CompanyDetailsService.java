package com.neima.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.neima.entity.CompanyInfo;
import com.neima.entity.UserInfo;
import com.neima.exceptions_and_errors.PanIdAlreadyExistsException;
import com.neima.repository.CompanyRepository;
import com.neima.repository.UserInfoDetailsRepository;

@Service
public class CompanyDetailsService {

	@Autowired
	private UserInfoDetailsRepository userInfoRepo;
	@Autowired
	private CompanyRepository companyRepo;

	@Autowired
	private PasswordEncoder passwordEncoder;

	public CompanyInfo saveCompanyDetails(CompanyInfo companyInfo) {
		// save pan and password to UserInfo
		String pan = companyInfo.getPan();
		String password = passwordEncoder.encode(companyInfo.getPassword());
		companyInfo.setPassword(password);
		String authority = "ROLE_COMPANY";
		UserInfo user = new UserInfo(pan, password, authority);

		if (userInfoRepo.findByPan(pan).isEmpty()) {
			userInfoRepo.save(user);

			// save other fields to CompanyInfo
			return companyRepo.save(companyInfo);
		}else {
			throw new PanIdAlreadyExistsException("Pan id already exist");
		}

	}
	
	@Cacheable(value = "CompanyInfo")
	public List<CompanyInfo> getAllCompanies(){
		return companyRepo.findAll();
	}

	@Cacheable(value = "CompanyInfo")
	public Optional<CompanyInfo> getCompany(int companyId) {
		// TODO Auto-generated method stub
		return companyRepo.findById(companyId);
	}

}
