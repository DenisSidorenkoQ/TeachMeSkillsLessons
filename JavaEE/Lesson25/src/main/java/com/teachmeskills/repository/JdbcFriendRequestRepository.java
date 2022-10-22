package com.teachmeskills.repository;

import com.teachmeskills.model.User;
import lombok.extern.log4j.Log4j2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Log4j2
public class JdbcFriendRequestRepository implements FriendRequestRepository {
    private final Connection connection;
    private static final String REQUEST_IS_EXISTS_SQL =
            "select * from friend_request where sender_id=? and recipient_id=?";
    private static final String CREATE_REQUEST_SQL =
            "insert into friend_request (sender_id, recipient_id) values ( ?, ?)";
    private static final String GET_ALL_INCOMING_REQUESTS_SQL
            = "select \"user\".user_id, \"user\".login from friend_request " +
            "inner join \"user\" on sender_id = user_id " +
            "where recipient_id=?";
    private static final String ADD_FRIEND_SQL =
            "insert into friends (first_user_id, second_user_id) values ( ?, ?)";
    private static final String DELL_REQUEST_SQL =
            "delete from friend_request where sender_id=? and recipient_id=?";
    private static final String GET_ALL_OUTGOING_REQUESTS_SQL =
            "select \"user\".user_id, \"user\".login from friend_request " +
                    "inner join \"user\" on recipient_id = user_id " +
                    "where sender_id=?";
    private static final String GET_ALL_FRIENDS_SQL = "select user_id, login from \"user\" " +
            "join friends " +
            "on first_user_id = user_id " +
            "where second_user_id=? " +
            "union " +
            "select user_id, login from \"user\" " +
            "join friends " +
            "on second_user_id = user_id " +
            "where first_user_id=?";

    public JdbcFriendRequestRepository(Connection connection) {
        this.connection = connection;
    }

    @Override
    public boolean isExists(int senderId, int recipientId) {
        try (PreparedStatement statement = connection.prepareStatement(REQUEST_IS_EXISTS_SQL)) {
            statement.setInt(1, senderId);
            statement.setInt(2, recipientId);

            ResultSet rs = statement.executeQuery();
            return rs.next();
        } catch (SQLException e) {
            e.getStackTrace();
            log.error("Error code: " + e.getErrorCode());
            return false;
        }
    }

    @Override
    public boolean createRequest(int senderId, int recipientId) {
        try (PreparedStatement statement = connection.prepareStatement(CREATE_REQUEST_SQL)) {
            statement.setInt(1, senderId);
            statement.setInt(2, recipientId);

            statement.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.getStackTrace();
            log.error("Error code: " + e.getErrorCode());
            return false;
        }
    }

    @Override
    public List<User> getUsersOfAllIncomingRequests(int recipientId) {
        try (PreparedStatement statement = connection.prepareStatement(GET_ALL_INCOMING_REQUESTS_SQL)) {
            statement.setInt(1, recipientId);

            List<User> userList = new ArrayList<>();
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                userList.add(new User(
                        Integer.parseInt(rs.getString("user_id")),
                        rs.getString("login"))
                );
            }
            return userList;
        } catch (SQLException e) {
            e.getStackTrace();
            log.error("Error code: " + e.getErrorCode());
            return new ArrayList<>();
        }
    }

    @Override
    public boolean addFriend(int senderId, int recipientId) {
        try (PreparedStatement statement = connection.prepareStatement(ADD_FRIEND_SQL)) {
            statement.setInt(1, senderId);
            statement.setInt(2, recipientId);

            statement.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.getStackTrace();
            log.error("Error code: " + e.getErrorCode());
            return false;
        }
    }

    @Override
    public boolean delFriendRequest(int senderId, int recipientId) {
        try (PreparedStatement statement = connection.prepareStatement(DELL_REQUEST_SQL)) {
            statement.setInt(1, senderId);
            statement.setInt(2, recipientId);

            statement.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.getStackTrace();
            log.error("Error code: " + e.getErrorCode());
            return false;
        }
    }

    @Override
    public List<User> getUsersOfAllOutgoingRequests(int senderId) {
        try (PreparedStatement statement = connection.prepareStatement(GET_ALL_OUTGOING_REQUESTS_SQL)) {
            statement.setInt(1, senderId);

            List<User> userList = new ArrayList<>();
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                userList.add(new User(
                        Integer.parseInt(rs.getString("user_id")),
                        rs.getString("login"))
                );
            }
            return userList;
        } catch (SQLException e) {
            e.getStackTrace();
            log.error("Error code: " + e.getErrorCode());
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
                userList.add(new User(
                        Integer.parseInt(rs.getString("user_id")),
                        rs.getString("login"))
                );
            }
            return userList;
        } catch (SQLException e) {
            e.getStackTrace();
            log.error("Error code: " + e.getErrorCode());
            return new ArrayList<>();
        }
    }
}
