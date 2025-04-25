package com.prashant.users.microservice.Services;

import com.prashant.users.microservice.DTOs.UserDto;

public interface IUserService {
    public void createPerson(UserDto userDto);
}
