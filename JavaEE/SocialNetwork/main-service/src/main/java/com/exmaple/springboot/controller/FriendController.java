package com.exmaple.springboot.controller;

import com.exmaple.springboot.client.MessageClient;
import com.exmaple.springboot.service.FriendService;
import com.exmaple.springboot.session.AuthorizedUser;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Slf4j
@Controller
@RequiredArgsConstructor
public class FriendController {
    private final FriendService friendService;
    private final AuthorizedUser authorizedUser;
    private final MessageClient messageClient;

    @PostMapping(path = "/deleteFriend")
    protected String deleteFriend(int friendId) {
        messageClient.deleteMessage(friendId, authorizedUser.getUserId());
        friendService.delFriend(authorizedUser.getUserId(), friendId);
        log.info("Delete friend. Id=[{}]", friendId);
        return "redirect:friendList";
    }

    @PostMapping(path = "/addFriend")
    protected String addFriend(@RequestParam int friendId) {
        friendService.addFriend(friendId, authorizedUser.getUserId());
        log.info("Add new friend. Id=[{}]", friendId);
        return "redirect:incomingRequests";
    }
}
