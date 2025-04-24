package com.prashant.user.microservice.Services;

import com.prashant.user.microservice.DTOs.UserDto;

public interface IUserService {
    public void createPerson(UserDto userDto);
}
