package com.prashant.payments.microservice.Services;

import com.prashant.payments.microservice.Constants.MessageConstant;
import com.prashant.payments.microservice.DTOs.ResponseDto;
import com.prashant.payments.microservice.DTOs.UserDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

public interface IUserService {

    public ResponseEntity<ResponseDto> user(Long id);

    public ResponseEntity<ResponseDto> allUsers();

    public ResponseEntity<ResponseDto> register(UserDto userDto);

    public ResponseEntity<ResponseDto> updateDetails(Long id, UserDto userDto);

    public ResponseEntity<ResponseDto> disableAccount(Long id);

}
