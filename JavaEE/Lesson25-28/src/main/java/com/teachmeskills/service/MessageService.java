package com.teachmeskills.service;

import com.teachmeskills.model.Message;
import com.teachmeskills.repository.MessageRepository;

import java.util.List;

public class MessageService {
    MessageRepository messageRepository;

    public MessageService(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    public List<Message> getMessages(int userId, int friendId) {
        return messageRepository.getMessages(userId, friendId);
    }

    public void sendMessage(int senderId, int recipientId, String text) {
        messageRepository.sendMessage(senderId, recipientId, text);
    }

    public void delAllMessages(int senderId, int recipientId) {
        messageRepository.delAllMessages(senderId, recipientId);
    }
}
