package com.teachmeskills.repository;

import com.teachmeskills.model.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public interface UserRepository {

    public boolean findUser(String login, String password);

    boolean findUserByName(String login);

    boolean insertNewUser(String login, String password);

    String getPasswordByUsername(String username);

    List<User> getAllUsers();

    List<User> getAllUsers(String parameter);
}
