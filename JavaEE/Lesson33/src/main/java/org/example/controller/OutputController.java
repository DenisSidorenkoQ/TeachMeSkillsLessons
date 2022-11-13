package org.example.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.model.User;
import org.example.service.user.UserService;
import org.example.session.AuthorizedUser;
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

        model.addAttribute("login", authorizedUser.getUsername());
        model.addAttribute("users", users);
        return "/Users.jsp";
    }
}
