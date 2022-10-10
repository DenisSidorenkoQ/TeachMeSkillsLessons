package com.teachmeskills.service;

import com.teachmeskills.model.User;
import com.teachmeskills.repository.JdbcUserRepository;
import com.teachmeskills.repository.UserRepository;

import java.io.IOException;
import java.io.Writer;
import java.util.List;

public class OutputService {

    private final UserRepository userRepository;

    public OutputService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAllUsers(String queryParameter) {
        if (queryParameter != null) {
            return userRepository.getAllUsers(queryParameter);
        } else {
            return userRepository.getAllUsers();
        }
    }

    public void outputList(List<User> users, Writer writer) {
        users.stream().forEach(user -> {
            try {
                writer.write("<h1>" + user.getUsername() + "</h1>");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
    }


}
