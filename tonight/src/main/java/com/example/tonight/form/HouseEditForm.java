package com.example.tonight.form;

import org.springframework.web.multipart.MultipartFile;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HouseEditForm {
	@NotNull
	private Integer id;

	@NotBlank(message = "Enter name.")
	private String name;

	private MultipartFile imageFile;

	@NotBlank(message = "Describe.")
	private String description;

	@NotNull(message = "Enter price.")
	@Min(value = 1, message = "Price must be 1 JPN or more.")
	private Integer price;

	@NotNull(message = "How many persons stay?")
	@Min(value = 1, message = "Capacity msut be 1 or more.")
	private Integer capacity;

	@NotBlank(message = "Enter postal code.")
	private String postalCode;

	@NotBlank(message = "Enter address.")
	private String address;
	
	@NotNull(message = "Enter phone number.")
	private String phoneNumber;

}
