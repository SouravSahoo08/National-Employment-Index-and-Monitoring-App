package com.neima.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@NoArgsConstructor
@ToString
public class UserInfo {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int userId;
	@Column(unique = true)
	private String pan;
	private String password;

	private String authority;

//	@ElementCollection
//	@CollectionTable(name = "user_authority", joinColumns = @JoinColumn(name = "user_id"))
//	private Set<String> authority;

	public UserInfo(String pan, String password, String authority) {
		super();
		this.pan = pan;
		this.password = password;
		this.authority = authority;
	}

}
