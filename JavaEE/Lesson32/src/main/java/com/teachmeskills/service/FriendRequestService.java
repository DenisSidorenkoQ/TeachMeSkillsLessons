package com.teachmeskills.service;

import com.teachmeskills.repository.FriendRequestRepository;

public class FriendRequestService {
    private FriendRequestRepository friendRequestRepository;

    public FriendRequestService(FriendRequestRepository friendRequestRepository) {
        this.friendRequestRepository = friendRequestRepository;
    }

    public boolean friendRequestIsExists(int senderId, int recipientId) {
        return friendRequestRepository.isExists(senderId, recipientId);
    }

    public boolean createRequest(int senderId, int recipientId) {
        return friendRequestRepository.createRequest(senderId, recipientId);
    }

    public boolean delRequest(int senderId, int recipientId) {
        return friendRequestRepository.delFriendRequest(senderId, recipientId);
    }
}
