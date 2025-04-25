package com.prashant.users.microservice.Mapper;

import com.prashant.users.microservice.DTOs.UserDto;
import com.prashant.users.microservice.Entities.User;

public class UserMapper {
    public static User mapToPerson(User user, UserDto userDto){
        user.setEmail(userDto.getEmail());
        user.setName(userDto.getName());
        user.setPhone(userDto.getPhone());
        return user;
    }
}