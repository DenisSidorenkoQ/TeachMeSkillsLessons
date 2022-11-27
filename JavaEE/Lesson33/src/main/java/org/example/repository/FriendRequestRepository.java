package org.example.repository;

public interface FriendRequestRepository {
    boolean isExists(int senderId, int recipientId);
    boolean createRequest(int senderId, int recipientId);
    boolean delFriendRequest(int senderId, int recipientId);
}
