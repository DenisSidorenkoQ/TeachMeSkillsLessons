package com.teachmeskills.service;

import com.teachmeskills.model.User;
import com.teachmeskills.repository.UserRepository;

import java.util.List;

public class UserService {

    UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public boolean register(String username, String password) {

        if (isExists(username)) {
            return false;
        } else {
            userRepository.insertNewUser(username, password);
            return true;
        }
    }

    public boolean isExists(String username, String password) {
        return userRepository.isExists(username, password);
    }

    public boolean isExists(String username) {
        return userRepository.isExists(username);
    }

    public List<User> getAllUsers(String queryParameter) {
        if (queryParameter != null) {
            return userRepository.getAllUsers(queryParameter);
        } else {
            return userRepository.getAllUsers();
        }
    }

    public int getUserIdByLogin(String login) {
        return userRepository.getUserIdByLogin(login);
    }
}
