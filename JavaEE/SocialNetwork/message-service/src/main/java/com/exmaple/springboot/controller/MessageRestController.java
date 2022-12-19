package com.exmaple.springboot.controller;

import com.exmaple.springboot.dto.MessageDto;
import com.exmaple.springboot.service.MessageService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class MessageRestController {
    private final MessageService messageService;

    @GetMapping(path = "/messages/{friendId}")
    protected List<MessageDto> getMessageList(@PathVariable(name = "friendId") int friendId,
                                              @RequestParam int userId) {
        return messageService.getMessages(userId, friendId);
    }

    @PostMapping(path = "/message/send/{friendId}")
    protected void sendMessage(@PathVariable int friendId,
                               @RequestParam String message,
                               @RequestParam int userId) {
        messageService.saveMessage(userId, friendId, message);
    }

    @PostMapping(path = "/message/delete/{friendId}")
    protected void deleteMessage(@PathVariable int friendId,
                               @RequestParam int userId) {
        messageService.delAllMessages(userId, friendId);
    }

}
