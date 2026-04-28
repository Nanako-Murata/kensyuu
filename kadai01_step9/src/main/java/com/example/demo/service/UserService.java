package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.UserSearchRequest;
import com.example.demo.entity.User;
import com.example.demo.repository.UserMapper;

@Service
public class UserService{
	//ユーザー情報Mapper
	@Autowired
	private UserMapper userMapper;
	
	//ユーザー情報検索
	public User search(UserSearchRequest usr) {
		return userMapper.search(usr.getId());
	}
}