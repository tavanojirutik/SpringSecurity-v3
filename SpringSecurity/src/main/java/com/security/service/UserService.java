package com.security.service;

import org.springframework.security.core.userdetails.User;

import com.security.dto.UserDto;
import com.security.entity.UserEntity;

public interface UserService {

	UserEntity save(UserDto userDto);
}
