package org.example.repository;



import org.example.model.Message;

import java.util.List;

public interface MessageRepository {
    List<Message> getMessages(int userId, int friendId);
    void saveMessage(int senderId, int recipientId, String text);
    void delAllMessages(int senderId, int recipientId);
}
