package com.prashant.user.microservice.Services;

import com.prashant.user.microservice.DTOs.UserDto;
import com.prashant.user.microservice.Repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserRepository personRepository;

    @Override
    public void createPerson(UserDto userDto) {

    }
}
