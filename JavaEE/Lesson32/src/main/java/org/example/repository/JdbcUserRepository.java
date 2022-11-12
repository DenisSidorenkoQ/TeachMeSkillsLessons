package org.example.repository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.model.User;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
@Repository
@RequiredArgsConstructor
public class JdbcUserRepository implements UserRepository {
    private final Connection connection;

    private static final String FIND_ALL_USERS_SQL = "select * from \"user\"";
    private static final String FIND_ALL_USERS_BY_PARAMETER_SQL = "select login from \"user\" where login like ?";
    private static final String FIND_USER_BY_NAME_SQL = "select * from \"user\" where login=?";
    private static final String INSERT_NEW_USER_SQL = "insert into \"user\" (login, password) values (?, ?)";
    private static final String GET_USER_ID_BY_NAME_SQL = "select user_id from \"user\" where login=?";
    private static final String GET_ALL_INCOMING_REQUESTS_SQL
            = "select \"user\".user_id, \"user\".login from friend_request " +
            "inner join \"user\" on sender_id = user_id " +
            "where recipient_id=?";
    private static final String GET_ALL_OUTGOING_REQUESTS_SQL =
            "select \"user\".user_id, \"user\".login from friend_request " +
                    "inner join \"user\" on recipient_id = user_id " +
                    "where sender_id=?";
    private static final String GET_ALL_FRIENDS_SQL = "select user_id, login from \"user\" " +
            "join friend " +
            "on first_user_id = user_id " +
            "where second_user_id=? " +
            "union " +
            "select user_id, login from \"user\" " +
            "join friend " +
            "on second_user_id = user_id " +
            "where first_user_id=?";
    private static final String GET_USER_HASHED_PASSWORD_SQL = "select password from \"user\" where login = ?";

    @Override
    public boolean isExists(String login) {
        try (PreparedStatement statement = connection.prepareStatement(FIND_USER_BY_NAME_SQL)) {
            statement.setString(1, login);

            ResultSet rs = statement.executeQuery();
            return rs.next();
        } catch (SQLException e) {
            log.error("Error code: " + e.getErrorCode(), e);
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
            log.error("Error code: " + e.getErrorCode(), e);
            return false;
        }
    }

    @Override
    public List<User> getAllUsers() {
        try (Statement statement = connection.createStatement()) {
            ResultSet rs = statement.executeQuery(FIND_ALL_USERS_SQL);
            List<User> users = new ArrayList<>();

            while (rs.next()) {
                users.add(User.builder()
                        .userId(Integer.parseInt(rs.getString("user_id")))
                        .login(rs.getString("login")).build()
                );
            }
            return users;
        } catch (SQLException e) {
            log.error("Error code: " + e.getErrorCode(), e);
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
                users.add(User.builder()
                        .userId(Integer.parseInt(rs.getString("user_id")))
                        .login(rs.getString("login")).build()
                );
            }
            return users;
        } catch (SQLException e) {
            log.error("Error code: " + e.getErrorCode(), e);
            return new ArrayList<>();
        }
    }

    @Override
    public int getUserIdByLogin(String login) {
        try (PreparedStatement statement = connection.prepareStatement(GET_USER_ID_BY_NAME_SQL)) {
            statement.setString(1, login);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                return rs.getInt("user_id");
            } else {
                throw new SQLException("user_id must not be null");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<User> getUsersOfAllIncomingRequests(int recipientId) {
        try (PreparedStatement statement = connection.prepareStatement(GET_ALL_INCOMING_REQUESTS_SQL)) {
            statement.setInt(1, recipientId);

            List<User> userList = new ArrayList<>();
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                userList.add(User.builder()
                        .userId(Integer.parseInt(rs.getString("user_id")))
                        .login(rs.getString("login")).build()
                );
            }
            return userList;
        } catch (SQLException e) {
            log.error("Error code: " + e.getErrorCode(), e);
            return new ArrayList<>();
        }
    }

    @Override
    public List<User> getUsersOfAllOutgoingRequests(int senderId) {
        try (PreparedStatement statement = connection.prepareStatement(GET_ALL_OUTGOING_REQUESTS_SQL)) {
            statement.setInt(1, senderId);

            List<User> userList = new ArrayList<>();
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                userList.add(User.builder()
                        .userId(Integer.parseInt(rs.getString("user_id")))
                        .login(rs.getString("login")).build()
                );
            }
            return userList;
        } catch (SQLException e) {
            log.error("Error code: " + e.getErrorCode(), e);
            return new ArrayList<>();
        }
    }

    @Override
    public List<User> getAllFriends(int userId) {
        try (PreparedStatement statement = connection.prepareStatement(GET_ALL_FRIENDS_SQL)) {
            statement.setInt(1, userId);
            statement.setInt(2, userId);

            List<User> userList = new ArrayList<>();
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                userList.add(User.builder()
                        .userId(Integer.parseInt(rs.getString("user_id")))
                        .login(rs.getString("login")).build()
                );
            }
            return userList;
        } catch (SQLException e) {
            log.error("Error code: " + e.getErrorCode(), e);
            return new ArrayList<>();
        }
    }

    @Override
    public Optional<String> GetUserHashedPassword(String username) {
        try (PreparedStatement statement = connection.prepareStatement(GET_USER_HASHED_PASSWORD_SQL)) {
            statement.setString(1, username);

            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                return Optional.of(rs.getString("password"));
            }
        } catch (SQLException e) {
            log.error("Error code: " + e.getErrorCode(), e);
        }
        return Optional.empty();
    }
}
