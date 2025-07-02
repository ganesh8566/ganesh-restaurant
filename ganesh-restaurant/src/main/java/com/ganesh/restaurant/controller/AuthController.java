package com.ganesh.restaurant.controller;

import com.ganesh.restaurant.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

	@Autowired
	private AuthService authService;

	@PostMapping("/login")
	public String login(@RequestParam String username, @RequestParam String password) {
		boolean success = authService.login(username, password);
		return success ? "Login successful" : "Invalid credentials";
	}

	@PostMapping("/register")
	public String register(@RequestParam String username, @RequestParam String password, @RequestParam String email,
			@RequestParam String role) {
		boolean success = authService.register(username, password, email, role);
		return success ? "Registration successful" : "Username already exists";
	}
}