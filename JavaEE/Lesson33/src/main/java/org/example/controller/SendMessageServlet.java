package org.example.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.service.MessageService;
import org.example.session.AuthorizedUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Slf4j
@Controller
@RequestMapping("/messages")
@RequiredArgsConstructor
public class SendMessageServlet {
    private final MessageService messageService;
    private final AuthorizedUser authorizedUser;

    @PostMapping
    protected String doPost(Model model,
                            @RequestParam String message,
                            @RequestParam int friendId,
                            @RequestParam String friendName) {
        messageService.sendMessage(authorizedUser.getUserId(), friendId, message);
        model.addAttribute("friendId", friendId);
        model.addAttribute("friendName", friendName);
        return "redirect:chat";
    }
}
