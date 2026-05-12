package com.example.mimpaku.form;

import org.springframework.web.multipart.MultipartFile;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class HouseRegisterForm {
	@NotBlank(message = "Enter the mimpaku's name.")
	private String name;

	private MultipartFile imageFile;

	@NotBlank(message = "Describe the mimpaku.")
	private String description;

	@NotNull(message = "Enter the price.")
	private Integer price;

	@NotNull(message = "How many persons can stay?")
	@Min(value = 0, message = "It must be 1 or more.")
	private Integer capacity;

	@NotBlank(message = "Enter the postal code.")
	private String postalCode;

	@NotBlank(message = "Enter the address.")
	private String address;

	@NotBlank(message = "Enter the phone number.")
	private String phoneNumber;

}
