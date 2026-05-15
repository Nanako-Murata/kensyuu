package com.example.tonight.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class WebSecurityConfig {
	@Bean
	public SecurityFilterChain chain(HttpSecurity http) {
		http.authorizeHttpRequests(auth -> auth

				// storage配下を公開
				.requestMatchers("/storage/**").permitAll()

				// CSS・画像も公開
				.requestMatchers("/css/**", "/images/**").permitAll()

				// その他は認証必要
				.anyRequest().authenticated())

				.formLogin(Customizer.withDefaults())

				.logout(Customizer.withDefaults());

	}

}
