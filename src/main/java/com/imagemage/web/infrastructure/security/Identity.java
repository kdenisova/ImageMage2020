package com.imagemage.web.infrastructure.security;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

public class Identity implements UserDetails {

    private final UserEntity userEntity;

    Identity(UserEntity userEntity) {
        this.userEntity = userEntity;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return userEntity.getPassword();
    }

    @Override
    public String getUsername() {
        return userEntity.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return !userEntity.isExpired();
    }

    @Override
    public boolean isAccountNonLocked() {
        return !userEntity.isLocked();
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return !userEntity.isExpired();
    }

    @Override
    public boolean isEnabled() {
        return userEntity.isEnabled();
    }
}
