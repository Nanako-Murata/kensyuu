package com.example.mimpaku.service;

import org.springframework.stereotype.Service;

import com.example.mimpaku.entity.User;
import com.example.mimpaku.entity.VerificationToken;
import com.example.mimpaku.repository.VerificationTokenRepository;

import jakarta.transaction.Transactional;

@Service
public class VerificationTokenService {
	private final VerificationTokenRepository verificationTokenRepository;

	public VerificationTokenService(VerificationTokenRepository verificationTokenRepository) {
		this.verificationTokenRepository = verificationTokenRepository;
	}

	@Transactional
	public void createToken(User user, String token) {
		VerificationToken vtoken = new VerificationToken();
		vtoken.setUser(user);
		vtoken.setToken(token);
		//listener class makes this service save token via repository
		verificationTokenRepository.save(vtoken);
	}
	//return result of searching token
	public VerificationToken getVerificationToken(String token) {
		return verificationTokenRepository.findByToken(token);
	}

}
