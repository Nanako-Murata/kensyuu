package com.example.mimpaku.form;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserEditForm {

	@NotNull
	private Integer id;

	@NotBlank(message = "Enter your name.")
	private String name;

	@NotBlank(message = "Enter your furigana.")
	private String furigana;

	@NotBlank(message = "Enter your postal code.")
	private String postalCode;

	@NotBlank(message = "Enter your address.")
	private String address;

	@NotBlank(message = "Enter your phone number.")
	@Pattern(regexp="^[0-9\\-]+$", message="Enter your valid email.")
	private String phoneNumber;

	@NotBlank(message = "Enter your email.")
	@Email(message="Enter your valid email.")
	private String email;

}
