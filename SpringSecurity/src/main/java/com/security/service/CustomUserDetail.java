package com.security.service;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.security.entity.UserEntity;

public class CustomUserDetail implements UserDetails{
	

	private UserEntity userEntity;
	
	public CustomUserDetail(UserEntity userEntity) {
		super();
		this.userEntity = userEntity;
	}
	
//	===========================================================================

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return List.of(() -> userEntity.getRole());
	}

	@Override
	public String getPassword() {
		
		return userEntity.getPassword();
	}	
	
	public String getFullname() {
		return userEntity.getFullname();
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return userEntity.getEmail();
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

	
	
}
