package com.example.samuraitravel.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class WebSecurityConfig {

	// SecurityFilterChainを設定するBean
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http.authorizeHttpRequests((requests) -> requests
				.requestMatchers("/css/**", "/images/**", "/js/**", "/storage/**", "/").permitAll() // すべてのユーザーにアクセスを許可するURL
				.requestMatchers("/signup/**").permitAll() // すべてのユーザーにアクセスを許可するURL
				.requestMatchers("/admin/**").hasRole("ADMIN") // 管理者にのみアクセスを許可するURL
				.anyRequest().authenticated() // 上記以外のURLはログインが必要（会員または管理者のどちらでもOK）
		);
	}

	).formLogin(form->form
	// ログインページのURL
	.loginPage("/login")
	// ログインフォーム送信先
	.loginProcessingUrl("/login")
	// ログイン成功時のリダイレクト先
	.defaultSuccessUrl("/?loggedIn",true)
	// ログイン失敗時のリダイレクト先
	.failureUrl("/login?error").permitAll()).logout(logout->logout
	// ログアウト時のリダイレクト先
	.logoutSuccessUrl("/?loggedOut").permitAll());

	return http.build();

	}

	// パスワードエンコーダーを設定するBean
	@Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}