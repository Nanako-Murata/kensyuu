package com.example.tonight.controller;

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

import com.example.tonight.entity.User;
import com.example.tonight.entity.VerificationToken;
import com.example.tonight.event.SignupEventPublisher;
import com.example.tonight.form.SignupForm;
import com.example.tonight.service.UserService;
import com.example.tonight.service.VerificationTokenService;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class AuthController {

	private final UserService userService;
	private final SignupEventPublisher signupEventPublisher;
	private final VerificationTokenService verificationTokenService;

	public AuthController(UserService userService, SignupEventPublisher signupEventPublisher,
			VerificationTokenService verificationTokenService) {
		this.userService = userService;
		this.signupEventPublisher = signupEventPublisher;
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

	@PostMapping("/signup")
	public String signup(@ModelAttribute @Validated SignupForm form, BindingResult result,
			RedirectAttributes attributes, HttpServletRequest request) {
		if (userService.isEmailRegistered(form.getEmail())) {
			FieldError error = new FieldError(result.getObjectName(), "email", "既に登録済みのメールアドレスです");
			result.addError(error);

		}
		if (!userService.isSamePassword(form.getPassword(), form.getPasswordConfirmation())) {
			FieldError error = new FieldError(result.getObjectName(), "password", "パスワードが一致しません");
			result.addError(error);
		}
		if (result.hasErrors()) {
			return "auth/signup";
		}
		// ユーザー作成
		User user = userService.create(form);
		// 現在のurlを取得
		String requestUrl = request.getRequestURL().toString();

		// イベント発火
		signupEventPublisher.publish(user, requestUrl);
		// メッセージ
		attributes.addFlashAttribute("successMessage",
				"ご入力いただいたメールアドレスに認証メールを送信いたしました。メールに記載されているリンクをクリックして会員登録を完了してください。");
		return "redirect:/";
	}

	// メールからこのurlをたたくとアクセスできて、認証が完了するメソッド
	@GetMapping("/signup/verify")
	public String verify(@RequestParam("token") String token, Model model) {
		VerificationToken vtoken = verificationTokenService.getVerificationToken(token);
		if (vtoken != null) {
			User user = vtoken.getUser();
			userService.enabledUser(user);
			model.addAttribute("successMessage", "会員登録が完了しました");
		} else {
			model.addAttribute("errorMessage", "トークンが無効です");
		}
		return "auth/verify";
	}

}
