package org.example.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.dto.UserDto;
import org.example.service.user.UserService;
import org.example.session.AuthorizedUser;
import org.example.validator.UserValidator;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Slf4j
@Controller
@RequestMapping("/registration")
@RequiredArgsConstructor
public class RegistrationController {
    private final UserService userService;
    private final UserValidator userValidator;
    private final AuthorizedUser authorizedUser;

    @PostMapping(consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    protected String registerNewUser(Model model,
                                     @Valid UserDto dto,
                                     BindingResult bindingResult) {
        if (!userValidator.validate(bindingResult, model)) {
            return "/Registration.jsp";
        }
        String username = dto.getLogin();
        String password = dto.getPassword();


        if (userService.register(username, password)) {
            log.info("User does not exist, registering a new user. Login[{}]", username);
            authorizedUser.setUserId(userService.getUserIdByLogin(dto.getLogin()));
            authorizedUser.setLogin(username);
            return "redirect:output";
        } else {
            log.info("User is already to exist. Login[{}]", username);
            return "/Authorization.jsp";
        }
    }
}
