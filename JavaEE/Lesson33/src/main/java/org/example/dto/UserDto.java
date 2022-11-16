package org.example.dto;

import lombok.Data;
import org.example.validator.ValidUserDto;

import javax.validation.constraints.NotEmpty;


@Data
@ValidUserDto
public class UserDto {
    @NotEmpty(message = "Login should not be empty")
    private final String login;
    @NotEmpty(message = "Password should not be empty")
    private final String password;
    @NotEmpty
    private final String confirmationPassword;
}
