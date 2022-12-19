package com.exmaple.springboot.service;


import com.exmaple.springboot.repository.FriendRepository;
import com.exmaple.springboot.repository.FriendRequestRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FriendService {
    private final FriendRequestRepository friendRequestRepository;
    private final FriendRepository friendRepository;

    public boolean addFriend(int senderId, int recipientId) {
        friendRequestRepository.delFriendRequest(senderId, recipientId);
        return friendRepository.addFriend(senderId, recipientId);
    }

    public boolean delFriend(int userId, int friendId) {
        return friendRepository.delFriend(userId, friendId);
    }

}
