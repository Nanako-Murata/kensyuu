package com.example.mimpaku.event;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

import com.example.mimpaku.entity.User;

@Component
public class SignupEventPublisher {
	private final ApplicationEventPublisher publisher;

	public SignupEventPublisher(ApplicationEventPublisher publisher) {
		this.publisher = publisher;
	}

	public void publishSignupEvent(User user, String requestUrl) {
		publisher.publishEvent(new SignupEvent(this, user, requestUrl));
	}

}
