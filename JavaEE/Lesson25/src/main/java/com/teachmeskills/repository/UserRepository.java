package com.teachmeskills.repository;

import com.teachmeskills.model.User;

import java.util.List;

public interface UserRepository {
    boolean isExists(String login, String password);
    boolean isExists(String login);
    boolean insertNewUser(String login, String password);
    List<User> getAllUsers();
    List<User> getAllUsers(String parameter);
    int getUserIdByLogin(String login);
}
