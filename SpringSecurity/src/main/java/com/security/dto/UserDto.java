package com.security.dto;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private String email;
	private String password;
	private String role;
	private String fullname;
	
	
	
	 
}
