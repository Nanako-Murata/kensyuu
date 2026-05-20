package com.example.tonight.event;

import java.util.UUID;

import org.springframework.context.event.EventListener;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

import com.example.tonight.entity.User;
import com.example.tonight.service.VerificationTokenService;

@Component
public class SignupEventListener {
	private final VerificationTokenService verificationTokenService;
	private final JavaMailSender javaMailSender;

	public SignupEventListener(VerificationTokenService verificationTokenService, JavaMailSender javaMailSender) {
		this.verificationTokenService = verificationTokenService;
		this.javaMailSender = javaMailSender;
	}

	@EventListener
	public void onSignupEvent(SignupEvent signupEvent) {
		User user = signupEvent.getUser();
		String token = UUID.randomUUID().toString();
		verificationTokenService.create(user, token);

		String email = user.getEmail();
		String subject = "メール認証";
		String confirmationUrl = signupEvent.getRequestUrl() + "/verify?token=" + token;
		String message = "リンクをクリックして会員登録を完了してください";
		SimpleMailMessage mail = new SimpleMailMessage();
		mail.setTo(email);
		mail.setSubject(subject);
		mail.setText(message + "\n" + confirmationUrl);
		javaMailSender.send(mail);
	}

}
