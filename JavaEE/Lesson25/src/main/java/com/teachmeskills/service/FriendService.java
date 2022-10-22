package com.teachmeskills.service;

import com.teachmeskills.model.User;
import com.teachmeskills.repository.FriendRequestRepository;

import java.util.List;

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

    public List<User> getUsersOfAllIncomingRequests(int recipientId) {
        return friendRequestRepository.getUsersOfAllIncomingRequests(recipientId);
    }

    public boolean delRequest(int senderId, int recipientId) {
        return friendRequestRepository.delFriendRequest(senderId, recipientId);
    }

    public boolean addFriend(int senderId, int recipientId) {
        return friendRequestRepository.addFriend(senderId, recipientId);
    }

    public List<User> getUsersOfAllOutgoingRequests(int senderId) {
        return friendRequestRepository.getUsersOfAllOutgoingRequests(senderId);
    }

    public List<User> getAllFriends(int userId) {
        return friendRequestRepository.getAllFriends(userId);
    }
}
