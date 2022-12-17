package com.exmaple.springboot.repository;


import com.exmaple.springboot.model.User;
import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface UserRepository extends Repository<User, Long> {

    @Query("select user_id, login from \"user\" where user_id = :userId")
    Optional<User> getUserById(@Param("userId") int userId);

    @Query("select * from \"user\" where login=:login")
    User getUserByLogin(@Param("login") String login);
    @Modifying
    @Query("update \"user\" " +
            "set password=:password " +
            "where user_id=:userId")
    void changeUserPassword(@Param("userId") int userId, @Param("password") String password);
}
