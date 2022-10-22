package com.teachmeskills.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class User {
    private int userId;
    private String login;
    private String password;

    public User(String login) {
        this.login = login;
    }
}
