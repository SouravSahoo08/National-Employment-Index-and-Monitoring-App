package com.neima.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.neima.entity.UserInfo;
import com.neima.repository.UserInfoDetailsRepository;

@Service
public class UserInfoUserDetailsService implements UserDetailsService {

	@Autowired
	UserInfoDetailsRepository userInfoDetailsRepo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<UserInfo> userInfo = userInfoDetailsRepo.findByPan(username);

		return userInfo.map(UserInfoUserDetails::new)
				.orElseThrow(() -> new UsernameNotFoundException("Username " + username + " not found"));
	}

}
