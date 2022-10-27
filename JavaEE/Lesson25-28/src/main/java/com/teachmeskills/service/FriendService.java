package com.teachmeskills.service;

import com.teachmeskills.repository.FriendRepository;
import com.teachmeskills.repository.FriendRequestRepository;


public class FriendService {
    FriendRequestRepository friendRequestRepository;
    FriendRepository friendRepository;

    public FriendService(FriendRequestRepository friendRequestRepository,
                         FriendRepository friendRepository) {
        this.friendRequestRepository = friendRequestRepository;
        this.friendRepository = friendRepository;
    }

    public boolean addFriend(int senderId, int recipientId) {
        friendRequestRepository.delFriendRequest(senderId, recipientId);
        return friendRepository.addFriend(senderId, recipientId);
    }

    public boolean delFriend(int userId, int friendId) {
        return friendRepository.delFriend(userId, friendId);
    }

}
