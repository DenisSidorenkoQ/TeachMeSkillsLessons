package com.teachmeskills.service;

import com.teachmeskills.repository.FriendRepository;
import com.teachmeskills.repository.FriendRequestRepository;
import com.teachmeskills.repository.UserRepository;


public class FriendService {
    FriendRequestRepository friendRequestRepository;
    UserRepository userRepository;
    FriendRepository friendRepository;

    public FriendService(FriendRequestRepository friendRequestRepository,
                         UserRepository userRepository,
                         FriendRepository friendRepository) {
        this.friendRequestRepository = friendRequestRepository;
        this.userRepository = userRepository;
        this.friendRepository = friendRepository;
    }

    public boolean addFriend(int senderId, int recipientId) {
        friendRequestRepository.delFriendRequest(senderId, recipientId);
        return friendRepository.addFriend(senderId, recipientId);
    }

}
