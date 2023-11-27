package com.springsecurity.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.service.annotation.GetExchange;

@RestController
@RequestMapping("/home")
public class SpringController {

	@GetExchange("/normal")
	public ResponseEntity<String> normal() {
		return ResponseEntity.ok("I Am a Normal User");
	}
	
	@GetMapping("/admin")
	public ResponseEntity<String> admin() {
		return ResponseEntity.ok("I Am a Admin");
	}
	
	@GetMapping("/public")
	public ResponseEntity<String> publicUser() {
		return ResponseEntity.ok("I Am a Public User");
	}
}
