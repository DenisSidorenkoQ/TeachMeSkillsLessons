package org.example.dto;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;


@Data
public class UserDto {
    @NotEmpty(message = "Login should not be empty")
    private final String login;
    @NotEmpty(message = "Password should not be empty")
    private final String password;
}
