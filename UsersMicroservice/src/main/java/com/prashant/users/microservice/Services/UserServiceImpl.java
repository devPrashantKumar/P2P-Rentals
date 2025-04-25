package com.prashant.users.microservice.Services;

import com.prashant.users.microservice.DTOs.UserDto;
import com.prashant.users.microservice.Repositories.UserRepository;
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
