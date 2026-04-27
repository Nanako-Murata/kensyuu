package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository.UserRepository;

//user information

@Service
public class UserService {
	// user informations

	@Autowired
	UserRepository userRepository;

	public List<User> searchAll() {
		return userRepository.findAll();

	}

	public User findById(Long id) {
	    return userRepository.findById(id).orElse(null);
	}
}