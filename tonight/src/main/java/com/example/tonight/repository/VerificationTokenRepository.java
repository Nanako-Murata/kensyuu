package com.example.tonight.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.tonight.entity.VerificationToken;

public interface VerificationTokenRepository extends JpaRepository<VerificationToken, Integer> {
	public Optional <VerificationToken> findByToken(String token);
}
