package com.teachmeskills.repository;

import com.teachmeskills.model.User;

import java.util.List;
import java.util.Optional;

public interface UserRepository {
    boolean isExists(String login);
    boolean insertNewUser(String login, String password);
    List<User> getAllUsers();
    List<User> getAllUsers(String parameter);
    int getUserIdByLogin(String login);
    List<User> getUsersOfAllIncomingRequests(int recipientId);
    List<User> getUsersOfAllOutgoingRequests(int senderId);
    List<User> getAllFriends(int userId);
    Optional<String> getUserHashedPassword(String username);
}
