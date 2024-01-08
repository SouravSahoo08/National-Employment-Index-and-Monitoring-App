package com.neima.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.neima.entity.StudentInfo;

@Repository
public interface StudentRepository extends JpaRepository<StudentInfo, Integer>{

}
