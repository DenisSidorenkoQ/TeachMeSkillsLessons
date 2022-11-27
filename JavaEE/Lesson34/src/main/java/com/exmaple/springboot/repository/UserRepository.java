package com.exmaple.springboot.repository;


import com.exmaple.springboot.model.User;

import java.util.List;
import java.util.Optional;

public interface UserRepository {
    boolean isExists(String login);
    boolean insertNewUser(String login, String password);
    List<User> getAllUsers();
    int getUserIdByLogin(String login);
    List<User> getUsersOfAllIncomingRequests(int recipientId);
    List<User> getUsersOfAllOutgoingRequests(int senderId);
    List<User> getAllFriends(int userId);
    Optional<String> getUserHashedPassword(String username);
    Optional<User> getUserById(int id);
}
