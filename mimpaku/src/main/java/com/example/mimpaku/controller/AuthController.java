package com.example.mimpaku.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.mimpaku.entity.User;
import com.example.mimpaku.entity.VerificationToken;
import com.example.mimpaku.event.SignupEventPublisher;
import com.example.mimpaku.form.SignupForm;
import com.example.mimpaku.service.UserService;
import com.example.mimpaku.service.VerificationTokenService;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class AuthController {
	private final UserService userService;
	private final SignupEventPublisher publisher;
	private final VerificationTokenService verificationTokenService;

	public AuthController(UserService userService, SignupEventPublisher publisher,
			VerificationTokenService verificationTokenService) {
		this.userService = userService;
		this.publisher = publisher;
		this.verificationTokenService = verificationTokenService;
	}

	@GetMapping("/login")
	public String login() {
		return "auth/login";
	}

	@GetMapping("/signup")
	public String signup(Model model) {
		model.addAttribute("signupForm", new SignupForm());
		return "auth/signup";
	}

//check all errors
	@PostMapping("/signup")
	public String signup(@ModelAttribute @Validated SignupForm signupForm, BindingResult result,
			RedirectAttributes attributes, HttpServletRequest http) {
		// add errors to binding result if email is already registered

		if (userService.isEmailRegistered(signupForm.getEmail())) {
			FieldError error = new FieldError(result.getObjectName(), "email", "This email is already registered.");
			result.addError(error);
		}
		// add an error to binding result if password is different form password to
		// confirm
		if (!userService.isPasswordSame(signupForm.getPassword(), signupForm.getPasswordConfirmation())) {
			FieldError error = new FieldError(result.getObjectName(), "password",
					"Password does not match password to confirm");
			result.addError(error);
		}
		// make user go back to signup form if errors occur
		if (result.hasErrors()) {
			return "auth/signup";

		}
		// make service create an account because there is no error
		User newUser = userService.create(signupForm);
		// get url
		String requestUrl = new String(http.getRequestURL());

		// make publisher occur event
		publisher.publishSignupEvent(newUser, requestUrl);
		// flash message
		attributes.addFlashAttribute("successMessage", "Sended email to you. Check your mail box.");

		return "redirect:/";

	}

	@GetMapping("/signup/verify")
	public String verify(@RequestParam(name = "token") String token, Model model) {
		VerificationToken vtoken = verificationTokenService.getVerificationToken(token);
		System.out.println(token);
		System.out.println(vtoken);

		if (vtoken != null) {
			User user = vtoken.getUser();
			userService.enableUser(user);
			String successMessage = "Registration completed.";
			model.addAttribute("successMessage", successMessage);

		} else {
			String errorMessage = "Token was void.";
			model.addAttribute("errorMessage", errorMessage);
		}
		return "auth/verify";

	}

}
