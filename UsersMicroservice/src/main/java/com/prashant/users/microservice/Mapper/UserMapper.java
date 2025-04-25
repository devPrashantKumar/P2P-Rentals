package com.prashant.users.microservice.Mapper;

import com.prashant.users.microservice.DTOs.UserDto;
import com.prashant.users.microservice.Entities.User;

public class UserMapper {
    public static User mapUserDtoToUser(UserDto userDto, User user){
        user.setEmail(userDto.getEmail());
        user.setName(userDto.getName());
        user.setPhone(userDto.getPhone());
        return user;
    }

    public static UserDto mapUserToUserDto(User user, UserDto userDto){
        userDto.setEmail(user.getEmail());
        userDto.setName(user.getName());
        userDto.setPhone(user.getPhone());
        return userDto;
    }
}