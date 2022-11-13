package org.example.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Value;

@Getter
@Value
@Builder
public class User {
    int userId;
    String login;
    String password;
}
