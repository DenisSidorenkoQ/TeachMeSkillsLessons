package com.teachmeskills.service;

import com.teachmeskills.repository.FriendRepository;
import com.teachmeskills.repository.FriendRequestRepository;
import com.teachmeskills.repository.MessageRepository;


public class FriendService {
    private FriendRequestRepository friendRequestRepository;
    private FriendRepository friendRepository;
    private MessageRepository messageRepository;

    public FriendService(FriendRequestRepository friendRequestRepository,
                         FriendRepository friendRepository, MessageRepository messageRepository) {
        this.friendRequestRepository = friendRequestRepository;
        this.friendRepository = friendRepository;
        this.messageRepository = messageRepository;
    }

    public boolean addFriend(int senderId, int recipientId) {
        friendRequestRepository.delFriendRequest(senderId, recipientId);
        return friendRepository.addFriend(senderId, recipientId);
    }

    public boolean delFriend(int userId, int friendId) {
        messageRepository.delAllMessages(userId, friendId);
        return friendRepository.delFriend(userId, friendId);
    }

}
