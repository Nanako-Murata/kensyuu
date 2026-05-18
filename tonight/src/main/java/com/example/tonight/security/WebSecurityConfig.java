package com.example.tonight.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebSecurityConfig implements WebMvcConfigurer {
	@Bean
	public SecurityFilterChain chain(HttpSecurity http) throws Exception {
		http.authorizeHttpRequests(auth -> auth

				// CSS・画像も公開
				.requestMatchers("/css/**", "/images/**").permitAll().anyRequest().permitAll());

		// その他は認証必要
		// ここoverride必須！

//				.formLogin(Customizer.withDefaults())
//
//				.logout(Customizer.withDefaults());
		return http.build();

	}
@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/storage/**").addResourceLocations("file:./storage/");
	}

}
