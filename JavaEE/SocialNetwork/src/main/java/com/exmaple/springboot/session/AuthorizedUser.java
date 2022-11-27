package com.exmaple.springboot.session;

import lombok.Data;

@Data
public class AuthorizedUser {
    private Integer userId;
    private String login;
}
