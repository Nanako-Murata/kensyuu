package com.example.mimpaku.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.mimpaku.entity.Role;
import com.example.mimpaku.entity.User;
import com.example.mimpaku.form.SignupForm;
import com.example.mimpaku.repository.RoleRepository;
import com.example.mimpaku.repository.UserRepository;

import jakarta.transaction.Transactional;

@Service
public class UserService {
	private final UserRepository userRepository;
	private final RoleRepository roleRepository;
	private final PasswordEncoder passwordEncoder;

	public UserService(UserRepository userRepository, RoleRepository roleRepository, PasswordEncoder passwordEncoder) {
		this.userRepository = userRepository;
		this.roleRepository = roleRepository;
		this.passwordEncoder = passwordEncoder;
	}

	@Transactional
	public User create(SignupForm signupForm) {
		User user = new User();
		Role role = roleRepository.findByName("ROLE_GENERAL");
		user.setName(signupForm.getName());
		user.setFurigana(signupForm.getFurigana());
		user.setPostalCode(signupForm.getPostalCode());
		user.setEmail(signupForm.getEmail());
		user.setAddress(signupForm.getAddress());
		user.setPhoneNumber(signupForm.getPhoneNumber());
		user.setPassword(passwordEncoder.encode(signupForm.getPassword()));
		user.setRole(role);
		user.setEnabled(false);
		return userRepository.save(user);

	}

	// check if email has been already registered
	public boolean isEmailRegistered(String email) {
		User user = userRepository.findByEmail(email);
		return user != null;
	}

	// Is password same as password to confirm?
	public boolean isPasswordSame(String password, String passwordConfirmation) {
		return password.equals(passwordConfirmation);
	}
	
	//let a new user enable
	@Transactional
	public void enableUser(User user) {
		user.setEnabled(true);
		//make repository save the user
		userRepository.save(user);
	}

}
