package com.example.tonight.controller;

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

import com.example.tonight.entity.User;
import com.example.tonight.form.UserEditForm;
import com.example.tonight.repository.UserRepository;
import com.example.tonight.security.UserDetailsImpl;
import com.example.tonight.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
	private final UserRepository userRepository;
	private final UserService userService;

	public UserController(UserRepository userRepository, UserService userService) {
		this.userRepository = userRepository;
		this.userService = userService;
	}

	@GetMapping
	public String index(@AuthenticationPrincipal UserDetailsImpl userDetailsImpl, Model model) {
		User user = userRepository.findById(userDetailsImpl.getUser().getId()).orElseThrow();
		model.addAttribute("user", user);
		return "user/index";
	}

	@GetMapping("/edit")
	public String edit(@AuthenticationPrincipal UserDetailsImpl userDetailsImpl, Model model) {
		User user = userRepository.findById(userDetailsImpl.getUser().getId()).orElseThrow();
		UserEditForm userEditForm = new UserEditForm(user.getId(), user.getName(), user.getFurigana(),
				user.getPostalCode(), user.getAddress(), user.getPhoneNumber(), user.getEmail());
		model.addAttribute("userEditForm", userEditForm);
		return "user/edit";

	}

	@PostMapping("/update")
	public String update(@ModelAttribute @Validated UserEditForm form, BindingResult result,
			RedirectAttributes attributes) {
		//true && true で{}を実行！
		if (userService.isEmailChanged(form) && userService.isEmailRegistered(form.getEmail())) {
			FieldError error = new FieldError(result.getObjectName(), "email", "既に登録済みのメールアドレスです");
			result.addError(error);
		}
		if (result.hasErrors()) {
			return "user/edit";
		}
		userService.update(form);
		attributes.addFlashAttribute("successMessage", "会員情報を編集しました");
		return "redirect:/user";
	}

}
