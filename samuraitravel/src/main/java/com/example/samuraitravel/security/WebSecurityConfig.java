package com.example.samuraitravel.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class WebSecurityConfig implements WebMvcConfigurer {
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

		http.authorizeHttpRequests((requests) -> requests

				// すべてのユーザーにアクセスを許可
				.requestMatchers("/css/**", "/images/**", "/js/**", "/storage/**", "/", "/houses/**", "/stripe/webhook")
				.permitAll()

				// 管理者のみアクセス可能
				.requestMatchers("/admin/**").hasRole("ADMIN")

				// その他はログイン必須
				.anyRequest().authenticated())

				.formLogin((form) -> form.loginPage("/login").loginProcessingUrl("/login")
						.defaultSuccessUrl("/?loggedIn").failureUrl("/login?error").permitAll())

				.logout((logout) -> logout.logoutSuccessUrl("/?loggedOut").permitAll())

				// Stripe webhook は CSRF除外
				.csrf((csrf) -> csrf.ignoringRequestMatchers("/stripe/webhook"));

		return http.build();
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/storage/**").addResourceLocations("file:storage/");
	}
}