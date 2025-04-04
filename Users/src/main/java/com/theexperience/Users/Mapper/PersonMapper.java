package com.theexperience.Users.Mapper;

import com.theexperience.Users.DTOs.PersonDto;
import com.theexperience.Users.Entities.Person;

public class PersonMapper {
    public static Person mapToPerson(Person person, PersonDto personDto){
        person.setEmail(personDto.getEmail());
        person.setUsername(personDto.getUsername());
        person.setFirstName(personDto.getFirstName());
        person.setLastName(personDto.getLastName());
        return person;
    }
}