package com.teachmeskills.repository;

import lombok.extern.log4j.Log4j2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@Log4j2
public class JdbcFriendRequestRepository implements FriendRequestRepository {
    private final Connection connection;
    private static final String REQUEST_IS_EXISTS_SQL =
            "select * from friend_request where sender_id=? and recipient_id=?";
    private static final String CREATE_REQUEST_SQL =
            "insert into friend_request (sender_id, recipient_id) values ( ?, ?)";

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
}
