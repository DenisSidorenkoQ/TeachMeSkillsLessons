package com.teachmeskills.model;

import lombok.Getter;
import lombok.Value;
import lombok.Builder;

@Getter
@Value
@Builder
public class User {
    int userId;
    String login;
    String password;
}
