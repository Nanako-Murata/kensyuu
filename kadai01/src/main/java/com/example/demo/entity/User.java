package com.example.demo.entity;

import java.io.Serializable;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

//user information
@Entity
@Data
@Table(name = "user")
public class User implements Serializable{
	// ID
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	// name
	@Column(name = "name")
	private String name;

	// address
	@Column(name = "address")
	private String address;

	// phone number
	@Column(name = "phone")
	private String phone;

	// update date
	@Column(name = "update_date")
	private Date updateDate;

	// create date
	@Column(name = "create_date")
	private Date createDate;

	// delete date
	@Column(name = "delete_date")
	private Date deleteDate;

}