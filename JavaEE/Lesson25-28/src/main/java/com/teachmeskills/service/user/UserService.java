package com.teachmeskills.service.user;

import com.teachmeskills.model.User;
import com.teachmeskills.repository.UserRepository;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.List;
import java.util.Optional;

public class UserService {

    UserRepository userRepository;
    PasswordEncrypter passwordEncrypter;

    public UserService(UserRepository userRepository, PasswordEncrypter passwordEncrypter) {
        this.userRepository = userRepository;
        this.passwordEncrypter = passwordEncrypter;
    }

    public boolean register(String username, String password) {

        if (isExists(username)) {
            return false;
        }
        try {
            String encryptedPassword = passwordEncrypter.getEncryptedPassword(password);

            userRepository.insertNewUser(username, encryptedPassword);
            return true;
        } catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean isExists(String username, String password) {
        Optional<String> encryptedPassword = userRepository.GetUserHashedPassword(username);
        if (encryptedPassword.isPresent()) {
            return passwordEncrypter.verifyPassword(password, encryptedPassword.get());
        }
        return false;
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
