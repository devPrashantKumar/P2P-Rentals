package com.prashant.user.microservice.Mapper;

import com.prashant.user.microservice.DTOs.UserDto;
import com.prashant.user.microservice.Entities.User;

public class UserMapper {
    public static User mapToPerson(User user, UserDto userDto){
        user.setEmail(userDto.getEmail());
        user.setName(userDto.getName());
        return user;
    }
}