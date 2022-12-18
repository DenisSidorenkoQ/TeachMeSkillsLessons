package com.exmaple.springboot.service;


import com.exmaple.springboot.model.User;
import com.exmaple.springboot.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public User getUserByLogin(String login) {
        return userRepository.getUserByLogin(login);
    }
}
