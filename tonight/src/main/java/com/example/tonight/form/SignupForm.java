package com.example.tonight.form;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class SignupForm {
	@NotBlank(message = "Enter your name.")

	private String name;

	@NotBlank(message = "Enter your name's furigana.")
	private String furigana;

	@NotBlank(message = "Enter your postal code.")
	private String postalCode;

	@NotBlank(message = "Enter your address.")
	private String address;

	@NotBlank(message = "Enter your phone number.")
	@Pattern(regexp="^[0-9\\-]+$", message="Enter your valid phone number.")
	private String phoneNumber;

	@NotBlank(message = "Enter your email.")
	@Email(message = "Enter valid email.")
	private String email;

	@NotBlank(message = "Enter your password.")
	@Size(min = 8, message = "Password must be at least 8 characters.")
	private String password;

	@NotBlank(message = "Enter your password again.")
	private String passwordConfirmation;

}
