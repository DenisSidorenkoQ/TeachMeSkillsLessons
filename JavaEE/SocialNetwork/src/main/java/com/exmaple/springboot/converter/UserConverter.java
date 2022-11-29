package com.exmaple.springboot.converter;

import com.exmaple.springboot.dto.UserDto;
import com.exmaple.springboot.model.User;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface UserConverter {

    List<UserDto> toDto(List<User> users);
}
