package com.exmaple.springboot.service;


import com.exmaple.springboot.dto.MessageDto;
import com.exmaple.springboot.repository.MessageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MessageService {
    private final MessageRepository messageRepository;

    public List<MessageDto> getMessages(int userId, int friendId) {
        return messageRepository.getMessages(userId, friendId);
    }

    public void saveMessage(int senderId, int recipientId, String text) {
        messageRepository.saveMessage(senderId, recipientId, text);
    }

    public void delAllMessages(int userId, int friendId) {
        messageRepository.delAllMessages(userId, friendId);
    }
}
