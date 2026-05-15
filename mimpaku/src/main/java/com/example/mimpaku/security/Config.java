package com.example.mimpaku.security;

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
public class Config implements WebMvcConfigurer {
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/storage/**").addResourceLocations("file:storage/");
	}

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http.authorizeHttpRequests((requests) -> requests
				// for all users
				.requestMatchers("/css/**", "/images/**", "/js/**", "/storage/**", "/", "/signup/**", "/houses/**",
						"/login", "/stripe/webhook")
				.permitAll()

				// only for admin
				.requestMatchers("/admin/**").hasRole("ADMIN")
				// only for logged-in users
				.anyRequest().authenticated()).formLogin((form) -> form
						// url for login page
						.loginPage("/login")
						// url to send login form
						.loginProcessingUrl("/login")
						// redirect if successful login
						.defaultSuccessUrl("/?loggedIn")
						// redirect if not-successful login
						.failureUrl("/login?error").permitAll())
				.logout((logout -> logout
						// redirect for logging out
						.logoutSuccessUrl("/?loggedOut").permitAll()));
		http.csrf(csrf -> csrf.ignoringRequestMatchers("/stripe/webhook"));
		return http.build();
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

}
