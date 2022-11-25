package com.exmaple.springboot.controller;

import com.exmaple.springboot.model.User;
import com.exmaple.springboot.service.user.UserService;
import com.exmaple.springboot.session.AuthorizedUser;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Slf4j
@Controller
@RequestMapping("/output")
@RequiredArgsConstructor
public class OutputController {
    private final UserService userService;
    private final AuthorizedUser authorizedUser;

    @GetMapping
    protected String outputUsers(Model model) {
        List<User> users = userService.getAllUsers();

        model.addAttribute("login", authorizedUser.getLogin());
        model.addAttribute("users", users);
        return "/Users";
    }
}
