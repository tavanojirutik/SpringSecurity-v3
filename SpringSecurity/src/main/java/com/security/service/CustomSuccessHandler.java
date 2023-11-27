package com.security.service;

import java.io.IOException;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Service;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Service
public class CustomSuccessHandler implements AuthenticationSuccessHandler{

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {
		// TODO Auto-generated method stub
		var authourities =authentication.getAuthorities();
		var role = authourities.stream().map(r->r.getAuthority()).findFirst();
		
		if(role.orElse("").equals("ADMIN")) {
			response.sendRedirect("/admin-page");
		}else if(role.orElse("").equals("USER")) {
			response.sendRedirect("/user-page");
		}else {
			response.sendRedirect("/errorx");
		}
	}

	
}
