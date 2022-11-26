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
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Slf4j
@Controller
@RequestMapping("/output")
@RequiredArgsConstructor
public class OutputController {
    private final UserService userService;
    private final AuthorizedUser authorizedUser;
    private static final int DEFAULT_PAGE_SIZE = 10;
    private static final int DEFAULT_PAGE_NUMBER = 1;

    @GetMapping
    protected String outputUsers(Model model,
                                 @RequestParam(required = false) Integer pageSize,
                                 @RequestParam(required = false) Integer pageNumber) {
        List<User> users;
        if (pageSize != null && pageNumber != null) {
            users = userService.getUserFromPage(pageSize, pageNumber);
        } else {
            pageSize = DEFAULT_PAGE_SIZE;
            pageNumber = DEFAULT_PAGE_NUMBER;
            users = userService.getUserFromPage(DEFAULT_PAGE_SIZE, DEFAULT_PAGE_NUMBER);
        }

        int pageCount = Math.round((float) userService.getUsersCount() / pageSize);

        model.addAttribute("pageCount", pageCount);
        model.addAttribute("pageSize", pageSize);
        model.addAttribute("pageNumber", pageNumber);
        model.addAttribute("login", authorizedUser.getLogin());
        model.addAttribute("users", users);
        return "/Users";
    }
}
