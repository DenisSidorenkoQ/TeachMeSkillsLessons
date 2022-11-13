package org.example.controller;

import lombok.RequiredArgsConstructor;
import org.example.model.Message;
import org.example.service.MessageService;
import org.example.session.AuthorizedUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.ServletException;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/chat")
@RequiredArgsConstructor
public class ChatOutputController {
    private final MessageService messageService;
    private final AuthorizedUser authorizedUser;

    @GetMapping
    protected String getMessageList(Model model, @RequestParam int friendId, @RequestParam String friendName) {
        List<Message> messageList = messageService.getMessages(authorizedUser.getUserId(), friendId);

        model.addAttribute("friendName", friendName);
        model.addAttribute("friendId", friendId);
        model.addAttribute("username", authorizedUser.getUsername());
        model.addAttribute("userId", authorizedUser.getUserId());
        model.addAttribute("messageList", messageList);
        return "/Chat.jsp";
    }

}
