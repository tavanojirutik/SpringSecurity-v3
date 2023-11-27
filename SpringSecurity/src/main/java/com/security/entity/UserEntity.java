package com.security.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "security_test", uniqueConstraints = @UniqueConstraint(columnNames = "email"))
public class UserEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	private long id;
	private String email;
	private String password;
	private String role;
	private String fullname;
	
	public UserEntity(String email, String fullname, String role, String password) {
		super();
		this.email = email;
		this.password = password;
		this.role = role;
		this.fullname = fullname;
	}
	
	


	

}
