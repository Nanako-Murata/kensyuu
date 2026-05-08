package com.example.demo.dto;

import java.io.Serializable;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.Pattern;

import lombok.Data;

@Data
public class UserRequest implements Serializable{
	

//name
@NotEmpty(message = "名前を入力してください")
@Size(max =100, message = "名前は100文字以内で入力してください")
private String name;

//住所
@Size(max=255, message="住所は255文字以内で入力してください")
private String address;

//telephone number
@Pattern(regexp="0\\d{1,4}-\\d{1,4}-\\d{4}" , message="電話番号の形式で入力してください")
private String phone;
}