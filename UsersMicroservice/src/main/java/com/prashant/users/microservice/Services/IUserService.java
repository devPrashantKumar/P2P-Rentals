package com.prashant.users.microservice.Services;

import com.prashant.users.microservice.Constants.MessageConstant;
import com.prashant.users.microservice.DTOs.ResponseDto;
import com.prashant.users.microservice.DTOs.UserDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.UUID;

public interface IUserService {

    public ResponseEntity<ResponseDto> user(UUID id);

    public ResponseEntity<ResponseDto> allUsers();

    public ResponseEntity<ResponseDto> register(UserDto userDto);

    public ResponseEntity<ResponseDto> updateDetails(UUID id, UserDto userDto);

    public ResponseEntity<ResponseDto> disableAccount(UUID id);

    public ResponseEntity<ResponseDto> reactivateAccount(UUID id);


}
