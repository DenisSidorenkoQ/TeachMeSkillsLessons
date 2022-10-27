package com.teachmeskills.repository;

import lombok.extern.slf4j.Slf4j;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@Slf4j
public class JdbcFriendRepository implements FriendRepository {
    private final Connection connection;

    private static final String ADD_FRIEND_SQL =
            "insert into friend (first_user_id, second_user_id) values ( ?, ?)";
    private static final String DEL_FRIEND_SQL =
            "delete from friend where first_user_id=? and second_user_id=? or first_user_id=? and second_user_id=?";

    public JdbcFriendRepository(Connection connection) {
        this.connection = connection;
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
    public boolean delFriend(int userId, int friendId) {
        try (PreparedStatement statement = connection.prepareStatement(DEL_FRIEND_SQL)) {
            statement.setInt(1, userId);
            statement.setInt(2, friendId);
            statement.setInt(3, friendId);
            statement.setInt(4, userId);

            statement.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.getStackTrace();
            log.error("Error code: " + e.getErrorCode());
            return false;
        }
    }
}
