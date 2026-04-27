package com.example.demo.repository.UserRepository;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.entity.*;

//user information repository

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}