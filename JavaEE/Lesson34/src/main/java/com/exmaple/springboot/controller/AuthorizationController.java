package com.exmaple.springboot.controller;

import com.exmaple.springboot.dto.UserDto;
import com.exmaple.springboot.service.user.UserService;
import com.exmaple.springboot.session.AuthorizedUser;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Slf4j
@Controller
@RequestMapping
@RequiredArgsConstructor
public class AuthorizationController {
    private final UserService userService;
    private final AuthorizedUser authorizedUser;

    @GetMapping(path = "/authorizationPage")
    protected String userAuthorization(Model model) {

        model.addAttribute("dto", new UserDto());
        return "Authorization";
    }

    @GetMapping(path = "/authorization")
    protected String userAuthorization(
            @Valid @ModelAttribute("dto") UserDto dto,
            BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "/Authorization";
        }

        if (userService.isExists(dto.getLogin(), dto.getPassword())) {
            int userId = userService.getUserIdByLogin(dto.getLogin());

            log.info("User is exists. Login[{}]", dto.getLogin());
            authorizedUser.setUserId(userId);
            authorizedUser.setLogin(dto.getLogin());
            return "redirect:output";
        } else {
            log.warn("User not exists. Login[{}]", dto.getLogin());
            return "/Authorization";
        }
    }
}
