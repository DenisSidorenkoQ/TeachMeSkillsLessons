package com.exmaple.springboot.controller;

import com.exmaple.springboot.client.MessageClient;
import com.exmaple.springboot.dto.MessageDto;
import com.exmaple.springboot.model.User;
import com.exmaple.springboot.service.UserService;
import com.exmaple.springboot.session.AuthorizedUser;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
public class ChatOutputController {
    private final MessageClient messageClient;
    private final AuthorizedUser authorizedUser;
    private final UserService userService;

    @GetMapping(path = "/chat/{friendId}")
    protected String getMessageList(Model model, @PathVariable(name = "friendId") int friendId) {
        List<MessageDto> messageList =
                messageClient.getMessageList(friendId, authorizedUser.getUserId());
        Optional<User> friend = userService.getUserById(friendId);

        if (friend.isPresent()) {
            model.addAttribute("messageList", messageList);
            model.addAttribute("userId", authorizedUser.getUserId());
            model.addAttribute("friendName", friend.get().getLogin());
            model.addAttribute("userLogin", authorizedUser.getLogin());
            return "/Chat";
        }
        return "redirect:/friendList";
    }

    @PostMapping(path = "/send-message/{friendId}")
    protected String sendMessage(@RequestParam String message,
                                 @PathVariable int friendId) {
        messageClient.sendMessage(friendId, message, authorizedUser.getUserId());
        return "redirect:/chat/" + friendId;
    }

}
