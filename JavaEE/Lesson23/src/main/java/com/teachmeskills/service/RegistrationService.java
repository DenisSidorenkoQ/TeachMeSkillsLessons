package com.teachmeskills.service;

import com.teachmeskills.repository.JdbcUserRepository;

import java.sql.Connection;

public class RegistrationService{
    private Connection connection;
    private JdbcUserRepository jdbcUserRepository;
    public RegistrationService(Connection connection) {
        this.connection = connection;
        jdbcUserRepository = new JdbcUserRepository(connection);
    }

    public boolean registerUser(String username, String password) {
        if(jdbcUserRepository.insertNewUser(username, password)) {
            return true;
        } else {
            return false;
        }
    }

    public boolean findUserByName(String username) {
        return jdbcUserRepository.findUserByName(username);
    }
}
