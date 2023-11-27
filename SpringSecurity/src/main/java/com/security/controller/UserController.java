package com.security.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.security.dto.UserDto;
import com.security.repository.UserRepository;
import com.security.service.UserService;

@Controller
public class UserController {

	@Autowired
	private UserDetailsService userDetailsService;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/regi")
	public String getRegistrationPage(@ModelAttribute("user") UserDto userDto) {
		return "register";
	}
	
	@PostMapping("/regi")
	public String saveData(@ModelAttribute("user") UserDto userDto,Model model) {
		userService.save(userDto);
		model.addAttribute("message", "Registerd Successfully");
		return "register";
	}
	
	@GetMapping("/login")
	public String getLoginPage() {
		System.out.println("Call Login");
		return "login";
	}
	
	@GetMapping("user-page")
	public String userPage(Model model,Principal principal) {
		UserDetails userDetails = userDetailsService.loadUserByUsername(principal.getName());
		model.addAttribute("userEntity", userDetails);
		System.out.println("Call User");
		return "user";
	}
		
	@GetMapping("admin-page")
		public String adminPage(Model model , Principal principal) {
			UserDetails userDetails = userDetailsService.loadUserByUsername(principal.getName());
			model.addAttribute("userEntity", userDetails);
			System.out.println("Call Admin");
			return "admin";
		}
}
