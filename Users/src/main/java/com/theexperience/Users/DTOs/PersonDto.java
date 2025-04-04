package com.theexperience.Users.DTOs;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PersonDto {
    private String username;

    private String email;

    private String firstName;

    private String lastName;
}
