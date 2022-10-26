package com.teachmeskills.repository;

public interface FriendRepository {
    boolean addFriend(int senderId, int recipientId);
}
