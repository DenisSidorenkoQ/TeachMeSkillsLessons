package com.teachmeskills.repository;

import com.teachmeskills.model.User;

import java.util.List;

public interface FriendRequestRepository {
    boolean isExists(int senderId, int recipientId);
    boolean createRequest(int senderId, int recipientId);
    List<User> getUsersOfAllIncomingRequests(int recipientId);
    boolean addFriend(int senderId, int recipientId);
    boolean delFriendRequest(int senderId, int recipientId);

    List<User> getUsersOfAllOutgoingRequests(int senderId);
}
