package com.example.tonight.event;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

import com.example.tonight.entity.User;

@Component
public class SignupEventPublisher {
	private final ApplicationEventPublisher applicationEventPublisher;

	public SignupEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
		this.applicationEventPublisher = applicationEventPublisher;
	}
	
	public void publish(User user, String requestUrl) {
		applicationEventPublisher.publishEvent(new SignupEvent(this, user, requestUrl));
	}
	//Controller->publisher
	//eventはevent情報を入れておくentityのようなもの
	//listenerが具体的な処理を行う

}
