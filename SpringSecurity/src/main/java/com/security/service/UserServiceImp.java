package com.security.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.security.dto.UserDto;
import com.security.entity.UserEntity;
import com.security.repository.UserRepository;
@Service
public class UserServiceImp implements UserService{
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	public UserEntity save(UserDto userDto) {
	UserEntity user = new UserEntity(userDto.getEmail(),userDto.getFullname(),userDto.getRole(),
			passwordEncoder.encode(userDto.getPassword()));
		return userRepository.save(user);
	}

}
