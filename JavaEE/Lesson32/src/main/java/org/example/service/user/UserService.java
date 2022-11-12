package org.example.service.user;


import lombok.RequiredArgsConstructor;
import org.example.model.User;
import org.example.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
//    private final PasswordEncrypter passwordEncrypter;

    public boolean register(String username, String password) {

        if (isExists(username)) {
            return false;
        }
//        try {
            String encryptedPassword = password;
//                    passwordEncrypter.getEncryptedPassword(password);

            userRepository.insertNewUser(username, encryptedPassword);
            return true;
//        } catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
//            throw new RuntimeException(e);
//        }
    }

    public boolean isExists(String username, String password) {
        Optional<String> encryptedPassword = userRepository.GetUserHashedPassword(username);
//        if (encryptedPassword.isPresent()) {
//            return passwordEncrypter.verifyPassword(password, encryptedPassword.get());
//        }
        return true;
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
