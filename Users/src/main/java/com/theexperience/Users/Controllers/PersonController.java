package com.theexperience.Users.Controllers;

import com.theexperience.Users.Constants.MessageConstant;
import com.theexperience.Users.DTOs.PersonDto;
import com.theexperience.Users.DTOs.ResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path="/api",produces = MediaType.APPLICATION_JSON_VALUE)
public class PersonController {

    @GetMapping("/hello")
    public String sayHello(){
        return "Hello World";
    }

    @PostMapping("/register")
    public ResponseEntity<ResponseDto> createPerson(@RequestBody PersonDto personDto){
        return ResponseEntity.status(HttpStatus.CREATED).body(new ResponseDto(MessageConstant.STATUS_201,MessageConstant.MESSAGE_SUCCESS));
    }
}
