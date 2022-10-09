package com.teachmeskills.repository;

import com.teachmeskills.model.User;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class JdbcUserRepository implements UserRepository{
    private Connection connection;
    private String FIND_ALL_USERS_SQL = "select * from users";

    public JdbcUserRepository(Connection connection) {
        this.connection = connection;
    }

    @Override
    public boolean findUser(String login, String password) {
        try (Statement statement = connection.createStatement()) {
            String findUser = "select login from users where login='" + login + "' and password='" + password + "'";
            ResultSet rs = statement.executeQuery(findUser);

            if (rs.next()) {
                return true;
            }

        } catch (SQLException e) {
        return false;
        }

        return false;
    }

    @Override
    public boolean findUserByName(String login) {
        try (Statement statement = connection.createStatement()){
            String findUserByLogin = "select * from users where login='" + login + "'";
            ResultSet rs = statement.executeQuery(findUserByLogin);

            if (rs.next()) {
                final User user = new User(rs.getString("login"), rs.getString("password"));
                return true;
            }
        } catch (SQLException e) {
            return false;
        }
        return false;
    }

    @Override
    public boolean insertNewUser(String login, String password) {
        try (Statement statement = connection.createStatement()) {
            String setInsertUser = "INSERT INTO users VALUES ('" + login + "','" + password + "')";
            statement.executeUpdate(setInsertUser);
            return true;
        } catch (SQLException e) {
            return false;
        }
    }

    @Override
    public String getPasswordByUsername(String username) {
        try (Statement statement = connection.createStatement()){
            String getPasswordByUsername = "select password from users where login='" + username + "'";
            ResultSet rs = statement.executeQuery(getPasswordByUsername);

            if (rs.next()) {
                return rs.getString("password");
            }
        } catch (SQLException e) {
            e.getStackTrace();
        }
        return "null";
    }

    @Override
    public List<User> getAllUsers() {
        try (Statement statement = connection.createStatement()){
            ResultSet rs = statement.executeQuery(FIND_ALL_USERS_SQL);

            List<User> users = new ArrayList<>();
            while (rs.next()) {
                users.add(new User(rs.getString("login")));
            }
            return users;
        } catch (SQLException e) {
            e.getStackTrace();
        }
        return null;
    }

    @Override
    public List<User> getAllUsers(String parameter) {
        try (Statement statement = connection.createStatement()){
            String findAllUsersByParameter ="select login from users where login like '" + parameter + "%'";
            ResultSet rs = statement.executeQuery(findAllUsersByParameter);

            List<User> users = new ArrayList<>();
            while (rs.next()) {
                users.add(new User(rs.getString("login")));
            }
            return users;
        } catch (SQLException e) {
            e.getStackTrace();
        }
        return null;
    }
}
