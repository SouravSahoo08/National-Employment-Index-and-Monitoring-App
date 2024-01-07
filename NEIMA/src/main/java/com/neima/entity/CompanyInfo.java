package com.neima.entity;

import java.io.Serializable;

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
public class CompanyInfo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7209112042635373298L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int companyId;
	@Column(unique = true)
	private String pan;
	private String password;
	private String companyName;
	private String emailId;
	private long contactNo;

}
