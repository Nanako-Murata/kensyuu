package com.example.demo.repository;
import org.apache.ibatis.annotations.Mapper;
import com.example.demo.entity.User;

@Mapper
public interface UserMapper{
	//ユーザー情報検索
	User search(Long id);
}