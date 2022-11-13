package com.teachmeskills.repository;

import lombok.extern.slf4j.Slf4j;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@Slf4j
public class JdbcFriendRequestRepository implements FriendRequestRepository {
    private final Connection connection;
    private static final String REQUEST_IS_EXISTS_SQL =
            "select * from friend_request where sender_id=? and recipient_id=?";
    private static final String CREATE_REQUEST_SQL =
            "insert into friend_request (sender_id, recipient_id) values ( ?, ?)";
    private static final String DELL_REQUEST_SQL =
            "delete from friend_request where sender_id=? and recipient_id=?";

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
            log.error("Error code: " + e.getErrorCode(), e);
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
            log.error("Error code: " + e.getErrorCode(), e);
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
            log.error("Error code: " + e.getErrorCode(), e);
            return false;
        }
    }
}
