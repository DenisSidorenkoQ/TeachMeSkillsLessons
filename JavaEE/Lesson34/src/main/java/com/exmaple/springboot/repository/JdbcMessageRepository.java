package com.exmaple.springboot.repository;

import com.exmaple.springboot.model.Message;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Repository
@RequiredArgsConstructor
public class JdbcMessageRepository implements MessageRepository {
    private final Connection connection;

    private static final String GET_ALL_SENT_AND_RECEIVED_MESSAGES_SQL =
            "select sender_id, recipient_id, text from message " +
            " where sender_id=? and recipient_id=? or sender_id=? and recipient_id=?";
    private static final String SEND_MESSAGE_SQL =
            "insert into message (sender_id, recipient_id, text) values ( ?, ?, ?)";
    private static final String DEL_ALL_MESSAGE_SQL =
            "delete from message where sender_id=? and recipient_id=? or sender_id=? and recipient_id=?";

    @Override
    public List<Message> getMessages(int userId, int friendId) {
        try (PreparedStatement statement = connection.prepareStatement(GET_ALL_SENT_AND_RECEIVED_MESSAGES_SQL)) {
            statement.setInt(1, userId);
            statement.setInt(2, friendId);
            statement.setInt(3, friendId);
            statement.setInt(4, userId);

            List<Message> messageList = new ArrayList<>();
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                messageList.add(Message.builder()
                        .senderId(rs.getInt("sender_id"))
                        .recipientId(rs.getInt("recipient_id"))
                        .text(rs.getString("text"))
                        .build());
            }
            return messageList;
        } catch (SQLException e) {
            log.error("Error code: " + e.getErrorCode(), e);
            return new ArrayList<>();
        }
    }

    @Override
    public void saveMessage(int senderId, int recipientId, String text) {
        try (PreparedStatement statement = connection.prepareStatement(SEND_MESSAGE_SQL)) {
            statement.setInt(1, senderId);
            statement.setInt(2, recipientId);
            statement.setString(3, text);

            statement.executeUpdate();
        } catch (SQLException e) {
            log.error("Error code: " + e.getErrorCode(), e);
        }
    }

    @Override
    public void delAllMessages(int senderId, int recipientId) {
        try (PreparedStatement statement = connection.prepareStatement(DEL_ALL_MESSAGE_SQL)) {
            statement.setInt(1, senderId);
            statement.setInt(2, recipientId);
            statement.setInt(3, recipientId);
            statement.setInt(4, senderId);

            statement.executeUpdate();
        } catch (SQLException e) {
            log.error("Error code: " + e.getErrorCode(), e);
        }
    }
}
