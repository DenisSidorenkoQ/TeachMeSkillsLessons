package com.exmaple.springboot.service.user;


import com.exmaple.springboot.model.User;
import com.exmaple.springboot.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncrypter passwordEncrypter;

    public boolean register(String username, String password) {

        if (isExists(username)) {
            return false;
        }
        String encryptedPassword = passwordEncrypter.getEncryptedPassword(password);

        userRepository.insertNewUser(username, encryptedPassword);
        return true;
    }

    public boolean isExists(String username, String password) {
        Optional<String> encryptedPassword = userRepository.getUserHashedPassword(username);
        return encryptedPassword.filter(hash -> passwordEncrypter.verifyPassword(password, hash)).isPresent();
    }

    public boolean isExists(String username) {
        return userRepository.isExists(username);
    }

    public List<User> getAllUsers() {
        return userRepository.getAllUsers();
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

    public Optional<User> getUserById(int id) {
        return userRepository.getUserById(id);
    }
}
