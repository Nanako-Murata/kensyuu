package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * ユーザー情報 Repository
 */
@Repository
public interface Repository extends JpaRepository<User, Long> {
}