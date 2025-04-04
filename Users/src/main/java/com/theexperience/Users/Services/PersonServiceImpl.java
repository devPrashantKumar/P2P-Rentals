package com.theexperience.Users.Services;

import com.theexperience.Users.DTOs.PersonDto;
import com.theexperience.Users.Repositories.PersonRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PersonServiceImpl implements IPersonService {

    @Autowired
    private PersonRepository personRepository;

    @Override
    public void createPerson(PersonDto personDto) {

    }
}
