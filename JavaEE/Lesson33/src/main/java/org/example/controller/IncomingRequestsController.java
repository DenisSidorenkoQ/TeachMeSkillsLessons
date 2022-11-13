package org.example.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.model.User;
import org.example.service.FriendRequestService;
import org.example.service.user.UserService;
import org.example.session.AuthorizedUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Slf4j
@Controller
@RequestMapping("/incomingRequests")
@RequiredArgsConstructor
public class IncomingRequestsController {
    private final UserService userService;
    private final FriendRequestService friendRequestService;
    private final AuthorizedUser authorizedUser;

    @GetMapping
    protected String getListOfUsersWithIncomingRequest(Model model) {
        List<User> listOfUsersWithIncomingRequest =
                userService.getUsersOfAllIncomingRequests(authorizedUser.getUserId());

        model.addAttribute("listOfUsersWithIncomingRequest", listOfUsersWithIncomingRequest);
        return "/IncomingRequests.jsp";
    }

    @PostMapping
    protected String deleteIncomingRequest(Model model, @RequestParam int requestUserId) {
        log.info("del friend request. Id=[{}]", requestUserId);
        friendRequestService.delRequest(requestUserId, authorizedUser.getUserId());
        getListOfUsersWithIncomingRequest(model);
        return "/IncomingRequests.jsp";
    }
}
