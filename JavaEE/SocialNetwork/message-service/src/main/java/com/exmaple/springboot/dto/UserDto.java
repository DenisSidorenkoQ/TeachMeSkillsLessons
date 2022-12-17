package com.exmaple.springboot.dto;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class UserDto {
    int userId;
    String login;
}
