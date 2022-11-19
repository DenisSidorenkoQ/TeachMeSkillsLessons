package org.example.service;


import lombok.RequiredArgsConstructor;
import org.example.model.Message;
import org.example.repository.MessageRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MessageService {
    private final MessageRepository messageRepository;

    public List<Message> getMessages(int userId, int friendId) {
        return messageRepository.getMessages(userId, friendId);
    }

    public void saveMessage(int senderId, int recipientId, String text) {
        messageRepository.saveMessage(senderId, recipientId, text);
    }

    public void delAllMessages(int senderId, int recipientId) {
        messageRepository.delAllMessages(senderId, recipientId);
    }
}
