package com.prashant.users.microservice.Controllers;

import com.prashant.users.microservice.DTOs.UserDto;
import com.prashant.users.microservice.DTOs.ResponseDto;
import com.prashant.users.microservice.Services.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path="/api",produces = MediaType.APPLICATION_JSON_VALUE)
public class UserController {

    @Autowired
    private IUserService userService;

    @Value("${spring.application.name}")
    private String applicationName;

    @GetMapping("/health-check")
    public String sayHello(){
        return String.format("Hello %s is UP and Running",applicationName);
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<ResponseDto> user(@PathVariable("id") Long id){
        return this.userService.user(id);
    }

    @GetMapping("/users")
    public ResponseEntity<ResponseDto> allUsers(){
        return this.userService.allUsers();
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
