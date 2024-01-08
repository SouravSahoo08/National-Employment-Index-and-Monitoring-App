package com.neima.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.neima.entity.UserInfo;

@Repository
public interface UserInfoDetailsRepository extends JpaRepository<UserInfo, Integer>{

	Optional<UserInfo> findByPan(String username);
	
}
