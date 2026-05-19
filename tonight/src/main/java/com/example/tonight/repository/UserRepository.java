package com.example.tonight.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.tonight.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {
	public User findByEmail(String email);

}
