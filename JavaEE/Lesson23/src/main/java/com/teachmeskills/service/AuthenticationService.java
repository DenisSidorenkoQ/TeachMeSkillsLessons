package com.teachmeskills.service;

import com.teachmeskills.repository.JdbcUserRepository;

import javax.servlet.http.Cookie;
import java.sql.Connection;

public class AuthenticationService{
    private Connection connection;
    private JdbcUserRepository jdbcUserRepository;
    public AuthenticationService(Connection connection) {
        this.connection = connection;
        jdbcUserRepository = new JdbcUserRepository(connection);
    }

    private boolean findUser(String username, String password) {
        return jdbcUserRepository.findUser(username, password);
    }

    private boolean findUserByName(String username) {
        return jdbcUserRepository.findUserByName(username);
    }

    private String getPasswordByUsername(String username) {
        return jdbcUserRepository.getPasswordByUsername(username);
    }

    public boolean checkUser(String username, String password){
        if(findUserByName(username)) {
            return getPasswordByUsername(username).equals(password);
        }
        return false;
    }
}
