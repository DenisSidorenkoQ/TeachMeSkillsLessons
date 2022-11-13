package org.example.controller;

import lombok.RequiredArgsConstructor;
import org.example.model.User;
import org.example.service.user.UserService;
import org.example.session.AuthorizedUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/friendList")
@RequiredArgsConstructor
public class OutputFriendsController {

    private final UserService userService;
    private final AuthorizedUser authorizedUser;

    @GetMapping
    protected String getFriendList(Model model) {
        List<User> friendsList = userService.getAllFriends(authorizedUser.getUserId());
        model.addAttribute("friendsList", friendsList);
        return "/Friends.jsp";
    }
}
