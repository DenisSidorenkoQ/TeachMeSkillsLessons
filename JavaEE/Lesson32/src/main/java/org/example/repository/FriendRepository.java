package org.example.repository;

public interface FriendRepository {
    boolean addFriend(int senderId, int recipientId);
    boolean delFriend(int userId, int friendId);
}
