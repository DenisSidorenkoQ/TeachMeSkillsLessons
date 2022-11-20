package com.exmaple.springboot.controller;

import com.exmaple.springboot.service.MessageService;
import com.exmaple.springboot.session.AuthorizedUser;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Slf4j
@Controller
@RequestMapping("/messages")
@RequiredArgsConstructor
public class SendMessageController {
    private final MessageService messageService;
    private final AuthorizedUser authorizedUser;

    @PostMapping
    protected String sendMessage(Model model,
                                 @RequestParam String message,
                                 @RequestParam int friendId) {
        messageService.saveMessage(authorizedUser.getUserId(), friendId, message);
        return "redirect:chat?friendId=" + friendId;
    }
}
