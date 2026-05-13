package com.example.mimpaku.event;

import java.util.UUID;

import org.springframework.context.event.EventListener;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

import com.example.mimpaku.entity.User;
import com.example.mimpaku.service.VerificationTokenService;

@Component
public class SignupEventListener {
	private final VerificationTokenService tokenService;
	private final JavaMailSender sender;

	public SignupEventListener(VerificationTokenService tokenService, JavaMailSender sender) {
		this.tokenService = tokenService;
		this.sender = sender;

	}

	@EventListener
	public void onSignupEvent(SignupEvent event) {
		User user = event.getUser();
		//make a token
		String token = UUID.randomUUID().toString();
		//save token -> service -> repository
		tokenService.createToken(user, token);
		//make a mail
		String recipientAddress = user.getEmail();
		String subject = "email";
		String confirmationUrl = event.getRequestUrl() + "/verify?token=" + token;
		String message = "tap the following URL,";

		SimpleMailMessage mail = new SimpleMailMessage();
		mail.setTo(recipientAddress);
		mail.setSubject(subject);
		mail.setText(message + "\n" + confirmationUrl);
		//send the mail
		sender.send(mail);

	}

}
