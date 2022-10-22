package com.teachmeskills.repository;

public interface FriendRequestRepository {
    boolean isExists(int senderId, int recipientId);
    boolean createRequest(int senderId, int recipientId);
}
