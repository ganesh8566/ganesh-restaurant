package com.ganesh.restaurant.service;

import com.ganesh.restaurant.model.User;
import com.ganesh.restaurant.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

	@Autowired
	private UserRepository userRepository;

	public boolean login(String username, String password) {
		User user = userRepository.findByUsername(username);
		if (user == null)
			return false;
		return user.getPassword().equals(password);
	}

	public String getRole(String username) {
		User user = userRepository.findByUsername(username);
		return user != null ? user.getRole() : null;
	}

	public boolean register(String username, String password, String email, String role) {
		User existing = userRepository.findByUsername(username);
		if (existing != null)
			return false;

		User user = new User();
		user.setUsername(username);
		user.setPassword(password); // In future we will hash this!
		user.setEmail(email);
		user.setRole(role.toUpperCase());

		userRepository.save(user);
		return true;
	}
}