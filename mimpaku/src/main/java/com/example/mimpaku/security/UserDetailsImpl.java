package com.example.mimpaku.security;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.example.mimpaku.entity.User;

public class UserDetailsImpl implements UserDetails {

	private final User user;
	private final Collection<GrantedAuthority> authorities;

	public UserDetailsImpl(User user, Collection<GrantedAuthority> authorities) {
		this.user = user;
		this.authorities = authorities;
	}
	
	public User getUser() {
		return user;
	}
	//return hashed password
	public String getPassword() {
		return user.getPassword();
	}
	//return username(email) which is used for logging in
	public String getUsername() {
		return user.getEmail();
	}
	
	//return collection of role
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities(){
		return authorities;
	}
	
	//return true if account is not expired
	public boolean isAccountNotExpired() {
		return true;
	}
	//return true if account is not locked
	public boolean isAccountNotlocled() {
		return true;
	}
	
	//return true if password is not expired
	public boolean isCredentialNotExpired() {
		return true;
	}
	//return true if user is enable
	@Override
	public boolean isEnabled() {
		//fetch true or false form database
		return user.isEnabled();
	}
}
