package com.exmaple.springboot.repository;

import com.exmaple.springboot.dto.MessageDto;
import com.exmaple.springboot.model.Profile;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProfileRepository extends Repository<Profile, Long> {
    @Query("select u.user_id, u.login, i.image_name from \"profile\"\n" +
            "join \"user\" u on u.user_id = profile.user_id\n" +
            "join image i on i.image_id = profile.image_id\n" +
            "where i.image_id=:userId")
    Profile getProfile(@Param("userId") int userId);
}
