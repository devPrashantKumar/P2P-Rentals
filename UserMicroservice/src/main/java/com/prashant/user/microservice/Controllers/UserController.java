package com.prashant.user.microservice.Controllers;

import com.prashant.user.microservice.Constants.MessageConstant;
import com.prashant.user.microservice.DTOs.UserDto;
import com.prashant.user.microservice.DTOs.ResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path="/api",produces = MediaType.APPLICATION_JSON_VALUE)
public class UserController {

    @GetMapping("/hello")
    public String sayHello(){
        return "Hello World";
    }

    @PostMapping("/register")
    public ResponseEntity<ResponseDto> createPerson(@RequestBody UserDto userDto){
        return ResponseEntity.status(HttpStatus.CREATED).body(new ResponseDto(MessageConstant.STATUS_201,MessageConstant.MESSAGE_SUCCESS));
    }
}
