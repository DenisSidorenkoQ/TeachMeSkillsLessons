package com.teachmeskills.model;

import lombok.Getter;
import lombok.Setter;
import lombok.Value;
import lombok.Builder;

@Getter
@Setter
@Value
@Builder
public class User {
    int userId;
    String login;
    String password;
}
