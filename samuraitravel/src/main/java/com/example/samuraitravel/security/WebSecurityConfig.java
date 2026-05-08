package com.example.samuraitravel.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class WebSecurityConfig {
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

		http.authorizeHttpRequests(
				(requests) -> requests.requestMatchers("/login", "/signup/**", "/css/**", "/images/**", "/").permitAll()
						// すべてのユーザーにアクセスを許可するURL

						.requestMatchers("/admin/**").hasRole("ADMIN")
						// 管理者にのみアクセスを許可するURL

						.requestMatchers("/user/**").authenticated() // ←追加
						.anyRequest().authenticated()
		// 上記以外はログイン必須
		).formLogin((form) -> form.loginPage("/login") // ログインページ
				.loginProcessingUrl("/login") // ログイン処理URL
				.defaultSuccessUrl("/?loggedIn") // 成功時
				.failureUrl("/login?error") // 失敗時
				.permitAll()).logout((logout) -> logout.logoutSuccessUrl("/?loggedOut") // ログアウト後
						.permitAll());

		return http.build();
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}