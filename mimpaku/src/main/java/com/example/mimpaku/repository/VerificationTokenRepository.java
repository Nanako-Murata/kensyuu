package com.example.mimpaku.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.mimpaku.entity.VerificationToken;

public interface VerificationTokenRepository extends JpaRepository<VerificationToken, Integer> {
	//listener -> service -> this repository
	//save token
	public VerificationToken findByToken(String token);

}
