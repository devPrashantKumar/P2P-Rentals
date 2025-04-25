package com.prashant.users.microservice.Controllers;

import com.prashant.users.microservice.Constants.MessageConstant;
import com.prashant.users.microservice.DTOs.UserDto;
import com.prashant.users.microservice.DTOs.ResponseDto;
import com.prashant.users.microservice.Services.IUserService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path="/api",produces = MediaType.APPLICATION_JSON_VALUE)
public class UserController {

    private IUserService userService;

    @Value("${spring.application.name}")
    private String applicationName;

    @GetMapping("/health-check")
    public String sayHello(){
        return String.format("Hello %s is UP and Running",applicationName);
    }

    @PostMapping("/register")
    public ResponseEntity<ResponseDto> register(@RequestBody UserDto userDto){
        return this.userService.register(userDto);
    }

    @PutMapping("/update-details/{id}")
    public ResponseEntity<ResponseDto> updateDetails(@PathVariable("id") Long id, @RequestBody UserDto userDto){
        return this.userService.updateDetails(id,userDto);
    }

    @DeleteMapping("/disable-account/{id}")
    public ResponseEntity<ResponseDto> disableAccount(@PathVariable("id") Long id){
        return this.userService.disableAccount(id);
    }
}
