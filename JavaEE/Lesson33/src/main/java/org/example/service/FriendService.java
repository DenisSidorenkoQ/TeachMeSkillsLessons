package org.example.service;


import lombok.RequiredArgsConstructor;
import org.example.repository.FriendRepository;
import org.example.repository.FriendRequestRepository;
import org.example.repository.MessageRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FriendService {
    private final FriendRequestRepository friendRequestRepository;
    private final FriendRepository friendRepository;
    private final MessageRepository messageRepository;

    public boolean addFriend(int senderId, int recipientId) {
        friendRequestRepository.delFriendRequest(senderId, recipientId);
        return friendRepository.addFriend(senderId, recipientId);
    }

    public boolean delFriend(int userId, int friendId) {
        messageRepository.delAllMessages(userId, friendId);
        return friendRepository.delFriend(userId, friendId);
    }

}
