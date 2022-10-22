package com.teachmeskills.service;

import com.teachmeskills.repository.FriendRequestRepository;

public class FriendService {
    FriendRequestRepository friendRequestRepository;

    public FriendService(FriendRequestRepository friendRequestRepository) {
        this.friendRequestRepository = friendRequestRepository;
    }

    public boolean friendRequestIsExists(int senderId, int recipientId) {
        return friendRequestRepository.isExists(senderId, recipientId);
    }

    public boolean createRequest(int senderId, int recipientId) {
        return friendRequestRepository.createRequest(senderId, recipientId);
    }
}
