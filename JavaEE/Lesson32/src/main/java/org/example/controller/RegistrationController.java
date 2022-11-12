package org.example.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.dto.UserDto;
import org.example.service.user.UserService;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletException;
import java.io.IOException;

@Slf4j
@Controller
@RequestMapping("/registration")
@RequiredArgsConstructor
public class RegistrationController {
    private UserService userService;

    @PostMapping(consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    protected String registerNewUser(final UserDto dto, Model model)
            throws ServletException, IOException {
        String username = dto.getLogin();
        String password = dto.getPassword();

        if (userService.register(username, password)) {
            log.info("User does not exist, registering a new user. Login[{}]", username);
            return "authorization";
        } else {
            log.info("User is already to exist. Login[{}]", username);
            return "/AuthorizationPage";
        }
    }
}
