package org.example.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.dto.UserDto;
import org.example.service.user.UserService;
import org.example.session.AuthorizedUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequestMapping("/authorization")
@RequiredArgsConstructor
public class AuthorizationController {
    private final UserService userService;
    private final AuthorizedUser authorizedUser;

    @GetMapping
    protected String userAuthorization(final UserDto dto, Model model) {
        String username = dto.getLogin();
        String password = dto.getPassword();
        int userId = userService.getUserIdByLogin(username);

        if (userService.isExists(username, password)) {
            log.info("User is exists. Login[{}]", username);
            authorizedUser.setUserId(userId);
            authorizedUser.setUsername(username);
            return "redirect:output";
        } else {
            log.warn("User not exists. Login[{}]", username);
            return "/Authorization.jsp";
        }
    }
}
