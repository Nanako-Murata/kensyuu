package com.example.mimpaku.form;

import org.hibernate.validator.constraints.Length;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class SignupForm {
	@NotBlank(message = "Enter your name.")
	private String name;

	@NotBlank(message = "Enter furigana of your name.")
	private String furigana;

	@NotBlank(message = "Enter postal code.")
	private String postalCode;

	@NotBlank(message = "Enter your address.")
	private String address;

	@NotBlank(message = "Enter your phone number.")
	private String phoneNumber;

	@NotBlank(message = "Enter your email address.")
	@Email(message = "Enter your email in the format of an email address.")
	private String email;

	@NotBlank(message = "Enter your password")
	@Length(min = 8, max = 100, message = "Password should be between 8 and 100 characters.")
	private String password;
	
	@NotBlank(message="Enter your password to confirm.")
	private String passwordConfirmation;

}
