package com.teachmeskills.service;

import com.teachmeskills.Util.EncryptUtilities;
import com.teachmeskills.model.User;
import com.teachmeskills.repository.UserRepository;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.List;

public class UserService {

    UserRepository userRepository;
    EncryptUtilities encryptUtilities;

    public UserService(UserRepository userRepository, EncryptUtilities encryptUtilities) {
        this.userRepository = userRepository;
        this.encryptUtilities = encryptUtilities;
    }

    public boolean register(String username, String password) {

        if (isExists(username)) {
            return false;
        } else {
            try {
                String encryptedPassword = encryptUtilities.getEncryptedPassword(password);

                userRepository.insertNewUser(username, encryptedPassword);
            } catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
                throw new RuntimeException(e);
            }

            return true;
        }
    }

    public boolean isExists(String username, String password) {
        try {
            String encryptedPassword = encryptUtilities.getEncryptedPassword(password);

            return userRepository.isExists(username, encryptedPassword);
        } catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
            throw new RuntimeException(e);
        }
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

    public List<User> getUsersOfAllOutgoingRequests(int senderId) {
        return userRepository.getUsersOfAllOutgoingRequests(senderId);
    }

    public List<User> getAllFriends(int userId) {
        return userRepository.getAllFriends(userId);
    }

    public List<User> getUsersOfAllIncomingRequests(int recipientId) {
        return userRepository.getUsersOfAllIncomingRequests(recipientId);
    }
}
