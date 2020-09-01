package com.imagemage.web.infrastructure.security;

import com.imagemage.web.validation.ValidPassword;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Objects;

@Entity
@Table(name = "User", schema = "public")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    public void setUsername(String username) {
        this.username = username;
    }

    @NotNull
    @Size(min = 2, message = "Username must be at least 2 characters long")
    private String username;

    public void setPassword(String password) {
        this.password = password;
    }

    @NotNull
    @ValidPassword
    private String password;

    @NotNull
    @Email
    private String email;
    private boolean expired;
    private boolean locked;
    private boolean enabled;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return username;
    }

    public boolean isExpired() {
        return expired;
    }

    public boolean isLocked() {
        return locked;
    }

    public boolean isEnabled() {
        return enabled;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserEntity that = (UserEntity) o;
        return id == that.id;
    }

    @Override
    public String toString() {
        return "UserEntity{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", expired=" + expired +
                ", locked=" + locked +
                ", enabled=" + enabled +
                '}';
    }
}
