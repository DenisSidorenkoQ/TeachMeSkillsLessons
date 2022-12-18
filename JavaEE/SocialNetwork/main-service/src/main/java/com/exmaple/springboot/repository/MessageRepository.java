package com.exmaple.springboot.repository;


import com.exmaple.springboot.dto.MessageDto;
import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

public interface MessageRepository extends Repository<MessageDto, Long> {
    @Query("delete from message " +
            "where sender_id = :senderId " +
            "and recipient_id = :recipientId " +
            "or sender_id = :recipientId " +
            "and recipient_id = :senderId")
    @Modifying
    void delAllMessages(@Param("senderId") int senderId, @Param("recipientId") int recipientId);
}
