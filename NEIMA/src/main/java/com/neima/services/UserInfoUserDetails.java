package com.neima.services;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.neima.entity.UserInfo;

public class UserInfoUserDetails implements UserDetails{
	
	private String panAsUsername;
	private String password;
	private List<GrantedAuthority> authorities;

	public UserInfoUserDetails(UserInfo userInfo) {
		panAsUsername = userInfo.getPan();
		password = userInfo.getPassword();
		authorities = Arrays.stream(userInfo.getAuthority().split(",")).map(SimpleGrantedAuthority::new)
				.collect(Collectors.toList());
//		authorities = userInfo.getAuthority().stream().map(SimpleGrantedAuthority::new)
//				.collect(Collectors.toSet());
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return authorities;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return password;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return panAsUsername;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

}
