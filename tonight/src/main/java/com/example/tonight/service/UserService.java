package com.example.tonight.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.tonight.entity.Role;
import com.example.tonight.entity.User;
import com.example.tonight.form.SignupForm;
import com.example.tonight.form.UserEditForm;
import com.example.tonight.repository.RoleRepository;
import com.example.tonight.repository.UserRepository;

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
	public User create(SignupForm form) {
		User user = new User();
		Role role = roleRepository.findByName("ROLE_GENERAL");

		user.setName(form.getName());
		user.setFurigana(form.getFurigana());
		user.setPostalCode(form.getPostalCode());
		user.setAddress(form.getAddress());
		user.setPhoneNumber(form.getPhoneNumber());
		user.setEmail(form.getEmail());
		user.setPassword(passwordEncoder.encode(form.getPassword()));
		user.setRole(role);
		user.setEnabled(false);

		userRepository.save(user);
		return user;
	}

	public boolean isEmailRegistered(String email) {
		User user = userRepository.findByEmail(email);
		// ユーザーがデータベースに登録済みだとtrueを返す
		return user != null;

	}

	public boolean isSamePassword(String password, String passwordConfirmation) {
		return password.equals(passwordConfirmation);
	}

	@Transactional
	public void enabledUser(User user) {
		user.setEnabled(true);
		userRepository.save(user);
	}

	@Transactional
	public void update(UserEditForm form) {
		User user = userRepository.findById(form.getId()).orElseThrow();
		user.setName(form.getName());
		user.setFurigana(form.getFurigana());
		user.setPostalCode(form.getPostalCode());
		user.setAddress(form.getAddress());
		user.setPhoneNumber(form.getPhoneNumber());
		user.setEmail(form.getEmail());

		userRepository.save(user);
	}
	
	public boolean isEmailChanged(UserEditForm form) {
		User user = userRepository.findById(form.getId()).orElseThrow();
		//不一致だったらtrueを返す
		return !form.getEmail().equals(user.getEmail());
	}

}
