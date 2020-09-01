package com.imagemage.web.infrastructure.security;

import com.imagemage.web.validation.ValidPassword;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class UserForm {

    @NotNull
    @Size(min = 2, message = "Username must be at least 2 characters long")
    private String username;

    @NotNull
    @ValidPassword
    private String password;

    @NotNull
    @Email
    private String email;
    private boolean expired;
    private boolean locked;
    private boolean enabled;

    public UserEntity toUserEntity() {
        return new UserEntity(username, password,email, expired, locked, enabled);
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isExpired() {
        return expired;
    }

    public void setExpired(boolean expired) {
        this.expired = expired;
    }

    public boolean isLocked() {
        return locked;
    }

    public void setLocked(boolean locked) {
        this.locked = locked;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }
}
