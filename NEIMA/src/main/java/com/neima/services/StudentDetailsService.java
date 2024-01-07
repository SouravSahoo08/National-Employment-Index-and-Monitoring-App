package com.neima.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.neima.entity.StudentInfo;
import com.neima.entity.UserInfo;
import com.neima.exceptions_and_errors.PanIdAlreadyExistsException;
import com.neima.repository.StudentRepository;
import com.neima.repository.UserInfoDetailsRepository;

@Service
public class StudentDetailsService {

	@Autowired
	private UserInfoDetailsRepository userInfoRepo;
	@Autowired
	private StudentRepository studentRepo;

	@Autowired
	private PasswordEncoder passwordEncoder;

	public StudentInfo saveStudentDetails(StudentInfo studentInfo) {
		// save pan and password to UserInfo
		String pan = studentInfo.getPan();
		String password = passwordEncoder.encode(studentInfo.getPassword());
		studentInfo.setPassword(password);
		String authority = "ROLE_STUDENT";
		UserInfo user = new UserInfo(pan, password, authority);

		if (userInfoRepo.findByPan(pan).isEmpty()) {
			userInfoRepo.save(user);

			// save other fields to StudentInfo
			return studentRepo.save(studentInfo);
		} else {
			throw new PanIdAlreadyExistsException("Pan id already exist");
		}

	}
}
