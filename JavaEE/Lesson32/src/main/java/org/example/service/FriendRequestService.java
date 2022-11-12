package org.example.service;


import lombok.RequiredArgsConstructor;
import org.example.repository.FriendRequestRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FriendRequestService {
    private final FriendRequestRepository friendRequestRepository;

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
