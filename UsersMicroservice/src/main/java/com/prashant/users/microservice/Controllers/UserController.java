package com.prashant.users.microservice.Controllers;

import com.prashant.users.microservice.Constants.MessageConstant;
import com.prashant.users.microservice.DTOs.UserDto;
import com.prashant.users.microservice.DTOs.ResponseDto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path="/api",produces = MediaType.APPLICATION_JSON_VALUE)
public class UserController {

    @Value("${spring.application.name}")
    private String applicationName;

    @GetMapping("/health-check")
    public String sayHello(){
        return String.format("Hello %s is UP and Running",applicationName);
    }

    @PostMapping("/register")
    public ResponseEntity<ResponseDto> register(@RequestBody UserDto userDto){
        return ResponseEntity.status(HttpStatus.CREATED).body(new ResponseDto(MessageConstant.STATUS_201,MessageConstant.MESSAGE_SUCCESS));
    }

    @PutMapping("/update-details")
    public ResponseEntity<ResponseDto> updateDetails(@RequestBody UserDto userDto){
        return ResponseEntity.status(HttpStatus.CREATED).body(new ResponseDto(MessageConstant.STATUS_201,MessageConstant.MESSAGE_SUCCESS));
    }

    @DeleteMapping("/disable-account/{id}")
    public ResponseEntity<ResponseDto> disableAccount(@PathVariable("id") Long id){
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseDto(MessageConstant.STATUS_200,String.format("Account Disabled Successfully for ID : %d",id)));
    }
}
