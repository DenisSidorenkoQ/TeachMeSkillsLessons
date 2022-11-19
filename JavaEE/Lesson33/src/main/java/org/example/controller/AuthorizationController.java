package org.example.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.dto.UserDto;
import org.example.service.user.UserService;
import org.example.session.AuthorizedUser;
import org.example.validator.UserValidator;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Slf4j
@Controller
@RequestMapping("/authorization")
@RequiredArgsConstructor
public class AuthorizationController {
    private final UserService userService;
    private final AuthorizedUser authorizedUser;
    private final UserValidator userValidator;

    @GetMapping
    protected String userAuthorization(
            Model model,
            @Valid UserDto dto,
            BindingResult bindingResult) {
        if (!userValidator.validate(bindingResult, model)) {
            return "/Authorization.jsp";
        }

        if (userService.isExists(dto.getLogin(), dto.getPassword())) {
            int userId = userService.getUserIdByLogin(dto.getLogin());

            log.info("User is exists. Login[{}]", dto.getLogin());
            authorizedUser.setUserId(userId);
            authorizedUser.setLogin(dto.getLogin());
            return "redirect:output";
        } else {
            log.warn("User not exists. Login[{}]", dto.getLogin());
            return "/Authorization.jsp";
        }
    }
}
