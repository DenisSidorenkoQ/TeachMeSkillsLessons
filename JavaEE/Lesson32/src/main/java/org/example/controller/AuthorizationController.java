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
import org.springframework.web.servlet.view.RedirectView;

@Slf4j
@Controller
@RequestMapping("/authorization")
@RequiredArgsConstructor
public class AuthorizationController {
    private final UserService userService;

    @PostMapping(consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    protected RedirectView userAuthorization(final UserDto dto, Model model) {
        String username = dto.getLogin();
        String password = dto.getPassword();
        int userId = userService.getUserIdByLogin(username);

        if (userService.isExists(username, password)) {
            log.info("User is exists. Login[{}]", username);
            model.addAttribute("username", username);
            model.addAttribute("userId", userId);
        } else {
            log.warn("User not exists. Login[{}]", username);
        }
        return new RedirectView("/AuthorizationPage");
    }
}
