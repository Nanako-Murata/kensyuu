package com.example.demo.dto;

import lombok.Data;
import java.io.Serializable;

@Data
public class UserSearchRequest implements Serializable{
	//ユーザーID
	private Long id;
	
}