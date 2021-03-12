package com.codessquad.qna.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity
public class User extends AbstractEntity {
    @Column(nullable = false, length = 20, unique = true)
    @NotEmpty
    private String userId;

    @JsonIgnore
    @NotEmpty
    private String password;

    @NotEmpty
    private String name;

    @Column(nullable = false, unique = true)
    @NotEmpty
    private String email;

    protected User() {
    }

    public String getUserId() {
        return userId;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void update(User newUser) {
        userId = newUser.userId;
        password = newUser.password;
        name = newUser.name;
        email = newUser.email;
    }

    public boolean hasMatchingId(Long id) {
        if (id == null) {
            return false;
        }
        return id.equals(getId());
    }

    public boolean hasMatchingPassword(String password) {
        if (password == null) {
            return false;
        }
        return password.equals(this.password);
    }
}

