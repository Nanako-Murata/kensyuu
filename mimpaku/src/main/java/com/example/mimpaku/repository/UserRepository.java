package com.example.mimpaku.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.mimpaku.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {
	public User findByEmail(String email);

}
