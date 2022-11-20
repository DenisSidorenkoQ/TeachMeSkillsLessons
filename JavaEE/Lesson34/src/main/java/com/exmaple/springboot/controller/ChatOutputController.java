package com.exmaple.springboot.controller;

import com.exmaple.springboot.model.Message;
import com.exmaple.springboot.model.User;
import com.exmaple.springboot.service.MessageService;
import com.exmaple.springboot.service.user.UserService;
import com.exmaple.springboot.session.AuthorizedUser;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
public class ChatOutputController {
    private final UserService userService;
    private final MessageService messageService;
    private final AuthorizedUser authorizedUser;

    @GetMapping(path = "/chat")
    protected String getMessageList(Model model, @RequestParam int friendId) {
        List<Message> messageList = messageService.getMessages(authorizedUser.getUserId(), friendId);

        Optional<User> friend = userService.getUserById(friendId);
        if (friend.isPresent()) {
            model.addAttribute("friendName", friend.get().getLogin());
            model.addAttribute("friendId", friendId);
            model.addAttribute("username", authorizedUser.getLogin());
            model.addAttribute("userId", authorizedUser.getUserId());
            model.addAttribute("messageList", messageList);
        }

        return "/Chat";
    }

}
