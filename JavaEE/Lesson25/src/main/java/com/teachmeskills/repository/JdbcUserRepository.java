package com.teachmeskills.repository;

import com.teachmeskills.model.User;
import lombok.extern.log4j.Log4j2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
@Log4j2
public class JdbcUserRepository implements UserRepository {
    private final Connection connection;
    private static final String FIND_ALL_USERS_SQL = "select * from \"user\"";
    private static final String FIND_ALL_USERS_BY_PARAMETER_SQL = "select login from \"user\" where login like ?";
    private static final String USER_IS_EXISTS_SQL = "select login from \"user\" where login=? and password=?";
    private static final String FIND_USER_BY_NAME_SQL = "select * from \"user\" where login=?";
    private static final String INSERT_NEW_USER_SQL = "insert into \"user\" values ( ?, ?)";

    public JdbcUserRepository(Connection connection) {
        this.connection = connection;
    }

    @Override
    public boolean isExists(String login, String password) {
        try (PreparedStatement statement = connection.prepareStatement(USER_IS_EXISTS_SQL)) {
            statement.setString(1, login);
            statement.setString(2, password);

            ResultSet rs = statement.executeQuery();
            return rs.next();
        } catch (SQLException e) {
            e.getStackTrace();
            log.error("Error code: " + e.getErrorCode());
            return false;
        }
    }
    @Override
    public boolean isExists(String login) {
        try (PreparedStatement statement = connection.prepareStatement(FIND_USER_BY_NAME_SQL)) {
            statement.setString(1, login);

            ResultSet rs = statement.executeQuery();
            return rs.next();
        } catch (SQLException e) {
            e.getStackTrace();
            log.error("Error code: " + e.getErrorCode());
            return false;
        }
    }

    @Override
    public boolean insertNewUser(String login, String password) {
        try (PreparedStatement statement = connection.prepareStatement(INSERT_NEW_USER_SQL)) {
            statement.setString(1, login);
            statement.setString(2, password);
            statement.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.getErrorCode();
            log.error("Error code: " + e.getErrorCode());
            return false;
        }
    }

    @Override
    public List<User> getAllUsers() {
        try (Statement statement = connection.createStatement()) {
            ResultSet rs = statement.executeQuery(FIND_ALL_USERS_SQL);
            List<User> users = new ArrayList<>();

            while (rs.next()) {
                users.add(new User(rs.getString("login")));
            }
            return users;
        } catch (SQLException e) {
            e.getStackTrace();
            log.error("Error code: " + e.getErrorCode());
            return new ArrayList<>();
        }
    }

    @Override
    public List<User> getAllUsers(String parameter) {
        try (PreparedStatement statement = connection.prepareStatement(FIND_ALL_USERS_BY_PARAMETER_SQL)) {
            statement.setString(1, parameter + "%");
            ResultSet rs = statement.executeQuery();
            List<User> users = new ArrayList<>();

            while (rs.next()) {
                users.add(new User(rs.getString("login")));
            }
            return users;
        } catch (SQLException e) {
            e.getStackTrace();
            log.error("Error code: " + e.getErrorCode());
            return new ArrayList<>();
        }
    }
}
