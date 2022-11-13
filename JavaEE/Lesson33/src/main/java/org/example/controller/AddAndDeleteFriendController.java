package org.example.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.service.FriendService;
import org.example.session.AuthorizedUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.ServletException;
import java.io.IOException;

@Slf4j
@Controller
@RequestMapping("/friend")
@RequiredArgsConstructor
public class AddAndDeleteFriendController {
    private final FriendService friendService;
    private final AuthorizedUser authorizedUser;

    @DeleteMapping
    protected void deleteFriend(Model model, int friendId) {
        friendService.delFriend(authorizedUser.getUserId(), friendId);
        log.info("Delete friend. Id=[{}]", friendId);
    }

    @PostMapping
    protected String addOrDeleteFriend(Model model, @RequestParam int friendId, @RequestParam String method) {
        if (method.equals("delete")) {
            deleteFriend(model, friendId);
            return "redirect:friendList";
        } else {
            friendService.addFriend(friendId, authorizedUser.getUserId());
            log.info("Add new friend. Id=[{}]", friendId);
            return "redirect:incomingRequests";
        }
    }
}
