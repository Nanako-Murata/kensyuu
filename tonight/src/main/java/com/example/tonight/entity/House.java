package com.example.tonight.entity;

import java.sql.Timestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "houses")
public class House {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;

	@Column(name = "name")
	private String name;

	@Column(name = "image_name")
	private String imageName;

	@Column(name = "description")
	private String description;

	@Column(name = "price")
	private Integer price;

	@Column(name = "capacity")
	private Integer capacity;

	@Column(name = "postal_code")
	private String postalCode;

	@Column(name = "address")
	private String address;

	@Column(name = "phone_number")
	private String phoneNumber;

	@Column(name = "created_at", insertable = false, updatable = false)
	private Timestamp createdAt;

	@Column(name = "updated_at", insertable = false, updatable = false)
	private Timestamp updatedAt;

}
//schema
//create table if not exists houses(
//		id int not null auto_increment primary key,
//		name varchar(50) not null,
//		image_name varchar(50),
//		description varchar(255) not null,
//		price int not null,
//		capacity int not null,
//		postal_code varchar(50) not null,
//		address varchar(255) not null,
//		phone_number varchar(50) not null,
//		created_at datetime not null default current_timestamp,
//		updated_at datetime not null default current_timestamp on update current_timestamp
//		
//	);
