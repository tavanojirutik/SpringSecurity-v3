package com.springsecurity.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfigration {

    @Bean
    PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

    @Bean
    UserDetailsService userDetailsService() {
		
		UserDetails normalUser= User
				.withUsername("rahul")
				.password(passwordEncoder().encode("rahul"))
				.roles("NORMAL")
				.build();
		
		UserDetails adminUserDetails = User
				.withUsername("pooja")
				.password(passwordEncoder().encode("pooja"))
				.roles("ADMIN")
				.build();
		
		return new InMemoryUserDetailsManager(normalUser , adminUserDetails);
	}


    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception{
		
		httpSecurity.csrf().disable()
			.authorizeRequests()
			
			.requestMatchers("/home/normal")
			.hasRole("NORMAL")
			
			.requestMatchers("/home/admin")
			.hasRole("ADMIN")
			
			.requestMatchers("/home/public")
			.permitAll()
			.anyRequest()
			.authenticated()
			.and()
			.formLogin();
		
		return httpSecurity.build();
		
		
	}
}
