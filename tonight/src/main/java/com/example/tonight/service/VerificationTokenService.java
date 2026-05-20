package com.example.tonight.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.tonight.entity.User;
import com.example.tonight.entity.VerificationToken;
import com.example.tonight.repository.VerificationTokenRepository;

import jakarta.transaction.Transactional;

@Service
public class VerificationTokenService {

	private final VerificationTokenRepository verificationTokenRepository;

	public VerificationTokenService(VerificationTokenRepository verificationTokenRepository) {

		this.verificationTokenRepository = verificationTokenRepository;
	}

	@Transactional
	public void create(User user, String token) {
		VerificationToken vtoken = new VerificationToken();
		vtoken.setUser(user);
		vtoken.setToken(token);
		verificationTokenRepository.save(vtoken);
	}

	public VerificationToken getVerificationToken(String token) {
		return verificationTokenRepository.findByToken(token).orElse(null);
	}
}
