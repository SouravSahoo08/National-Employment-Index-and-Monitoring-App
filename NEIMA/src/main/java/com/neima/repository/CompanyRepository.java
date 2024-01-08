package com.neima.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.neima.entity.CompanyInfo;

@Repository
public interface CompanyRepository extends JpaRepository<CompanyInfo, Integer>{
	
}
