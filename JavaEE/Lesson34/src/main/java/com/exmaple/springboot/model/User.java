package com.exmaple.springboot.model;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class User {
    int userId;
    String login;
    String password;
}
