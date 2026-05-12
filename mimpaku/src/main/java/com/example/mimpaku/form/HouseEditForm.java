package com.example.mimpaku.form;

import org.springframework.web.multipart.MultipartFile;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class HouseEditForm {
	@NotNull
	private Integer id;

	@NotNull(message = "enter the name.")
	private String name;

	private MultipartFile imageFile;

	@NotBlank(message = "describe.")
	private String description;

	@NotNull(message = "enter the price")
	@Min(value = 1, message = "price must be 1 JPN or more.")
	private Integer price;

	@NotNull(message = "how many persons stay?")
	@Min(value = 1, message = "at least 1 person stay.")
	private Integer capacity;

	@NotBlank(message = "enter postal code.")
	private String postalCode;

	@NotBlank(message = "enter the address.")
	private String address;

	@NotBlank(message = "enter the phone number.")
	private String phoneNumber;
}
