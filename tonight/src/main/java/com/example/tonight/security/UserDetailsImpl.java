package com.example.tonight.security;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.example.tonight.entity.Role;
import com.example.tonight.entity.User;

public class UserDetailsImpl implements UserDetails{
	
	private final User user;
	private final Collection<GrantedAuthority> authorities;
	
	public UserDetailsImpl(User user, Collection<GrantedAuthority> authorities) {
		this.user = user;
		this.authorities = authorities;
		
		
		}
	public User getUser() {
		return user;
		
		
	}
	//hashed passwordを返す
	public String getPassword() {
		return user.getPassword();
		
	}
	@Override
	//ログイン時に利用するメールアドレスを返す
	public String getUsername() {
		return user.getEmail();
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities(){
		return authorities;
	}
	@Override
	public boolean isAccountNonExpired() {
		return true;
	}
	@Override
	public boolean isAccountNonLocked() {
		return true;
	}
	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}
	@Override
	public boolean isEnabled() {
		return user.isEnabled();
	}
	
	

}
