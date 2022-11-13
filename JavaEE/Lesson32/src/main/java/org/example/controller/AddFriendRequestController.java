package org.example.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.service.FriendRequestService;
import org.example.session.AuthorizedUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Slf4j
@Controller
@RequestMapping("/friendRequest")
@RequiredArgsConstructor
public class AddFriendRequestController {
    private final FriendRequestService friendRequestService;
    private final AuthorizedUser authorizedUser;

    @PostMapping
    protected String sendFriendRequest(Model model, @RequestParam int recipientId) {

        if (friendRequestService.friendRequestIsExists(authorizedUser.getUserId(), recipientId)) {
            log.info("Request is exists. Id=[{}]", recipientId);
        } else {
            friendRequestService.createRequest(authorizedUser.getUserId(), recipientId);
            log.info(
                    "Request not exists. Create new request senderId=[{}] recipientId=[{}]",
                    authorizedUser.getUserId(),
                    recipientId
            );
        }
        return "redirect:output";
    }
}
