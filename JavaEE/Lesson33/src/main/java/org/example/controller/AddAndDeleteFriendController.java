package org.example.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.service.FriendService;
import org.example.session.AuthorizedUser;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Slf4j
@Controller
@RequestMapping("/friend")
@RequiredArgsConstructor
public class AddAndDeleteFriendController {
    private final FriendService friendService;
    private final AuthorizedUser authorizedUser;

    @DeleteMapping
    protected void deleteFriend(int friendId) {
        friendService.delFriend(authorizedUser.getUserId(), friendId);
        log.info("Delete friend. Id=[{}]", friendId);
    }

    @PostMapping
    protected String addOrDeleteFriend(@RequestParam int friendId, @RequestParam String method) {
        if (method.equals("delete")) {
            deleteFriend(friendId);
            return "redirect:friendList";
        } else {
            friendService.addFriend(friendId, authorizedUser.getUserId());
            log.info("Add new friend. Id=[{}]", friendId);
            return "redirect:incomingRequests";
        }
    }
}
