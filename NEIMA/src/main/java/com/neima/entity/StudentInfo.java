package com.neima.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class StudentInfo {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int studentId;
	@Column(unique = true)
	private String pan;
	private String password;
	private String studentName;
	private String emailId;
	private long contactNo;

}
