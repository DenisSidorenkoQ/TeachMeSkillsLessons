package com.teachmeskills.repository;


import com.teachmeskills.model.Message;

import java.util.List;

public interface MessageRepository {
    List<Message> getMessages(int userId, int friendId);
    void sendMessage(int senderId, int recipientId, String text);
    void delAllMessages(int senderId, int recipientId);
}
