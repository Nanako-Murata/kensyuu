package com.example.tonight.form;

import org.springframework.web.multipart.MultipartFile;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class HouseRegisterForm {
	@NotBlank(message = "Enter name.")
	private String name;

	private MultipartFile imageFile;

	@NotBlank(message = "Enter discription.")
	private String description;

	@NotNull(message = "Enter 1 JPN or more.")
	private Integer price;

	@NotNull(message = "How many people stay?.")
	@Min(value = 1, message = "Enter 1 or more.")
	private Integer capacity;

	@NotBlank(message = "Enter postal code.")
	private String postalCode;

	@NotBlank(message = "Enter address.")
	private String address;

	@NotBlank(message = "Enter phone number.")
	private String phoneNumber;

}
