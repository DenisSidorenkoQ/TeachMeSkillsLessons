package com.exmaple.springboot.controller;

import com.exmaple.springboot.converter.UserConverter;
import com.exmaple.springboot.dto.UserDto;
import com.exmaple.springboot.model.User;
import com.exmaple.springboot.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class OutputUsersRestController {
    private final UserService userService;
    private final UserConverter userConverter;

    @GetMapping
    protected List<UserDto> getUsers(@RequestParam(required = false) Integer pageSize,
                                        @RequestParam(required = false) Integer pageNumber) {
        List<User> users;
        users = userService.getUserFromPage(pageSize, pageNumber);
        return userConverter.toDto(users);
    }
}

