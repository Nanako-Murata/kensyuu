package com.example.mimpaku.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.mimpaku.entity.User;
import com.example.mimpaku.form.UserEditForm;
import com.example.mimpaku.repository.UserRepository;
import com.example.mimpaku.security.UserDetailsImpl;
import com.example.mimpaku.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
	private final UserRepository userRepository;
	private final UserService userService;

	public UserController(UserRepository userRepository, UserService userService) {
		this.userRepository = userRepository;
		this.userService = userService;

	}

	// show user's details
	@GetMapping
	public String index(@AuthenticationPrincipal UserDetailsImpl userDetailsImpl, Model model) {
		User user = userRepository.getReferenceById(userDetailsImpl.getUser().getId());
		model.addAttribute("user", user);

		return "user/index";

	}

	@GetMapping("/edit")
	public String edit(@AuthenticationPrincipal UserDetailsImpl userDetailsImpl, Model model) {
		User user = userRepository.getReferenceById(userDetailsImpl.getUser().getId());
		UserEditForm userEditForm = new UserEditForm(user.getId(), user.getName(), user.getFurigana(),
				user.getPostalCode(), user.getAddress(), user.getPhoneNumber(), user.getEmail());
		model.addAttribute("userEditForm", userEditForm);
		return "user/edit";
	}

	@PostMapping("/update")
	public String update(@ModelAttribute @Validated UserEditForm userEditForm, BindingResult result,
			RedirectAttributes attributes) {
		// email has changed but it is already registered, throw an error
		if (userService.isEmailChanged(userEditForm) && userService.isEmailRegistered((userEditForm.getEmail()))) {
			FieldError error = new FieldError(result.getObjectName(), "email", "This email is already registered.");
			result.addError(error);

		}
		if (result.hasErrors()) {
			return "user/edit";
		}
		userService.update(userEditForm);
		attributes.addFlashAttribute("successMessage", "Edited your details.");
		return "redirect:/user";
	}

}
