package com.example.samuraitravel.security;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.example.samuraitravel.entity.User;

public class UserDetailsImpl implements UserDetails {

    private final User user;
    private final Collection<? extends GrantedAuthority> authorities;

    public UserDetailsImpl(User user, Collection<? extends GrantedAuthority> authorities) {
        this.user = user;
        this.authorities = authorities;
    }

    public User getUser() {
        return user;
    }

    // ハッシュ化済みパスワード
    @Override
    public String getPassword() {
        return user.getPassword();
    }

    // ログインに使用するユーザー名（メール）
    @Override
    public String getUsername() {
        return user.getEmail();
    }

    // 権限一覧
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    // アカウント期限切れチェック
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    // アカウントロックチェック
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    // パスワード期限切れチェック
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    // 有効ユーザーかどうか
    @Override
    public boolean isEnabled() {
        return user.getEnabled();
    }
}