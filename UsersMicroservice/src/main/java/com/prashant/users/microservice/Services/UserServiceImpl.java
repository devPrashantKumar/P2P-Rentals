package com.prashant.users.microservice.Services;

import com.prashant.users.microservice.Constants.MessageConstant;
import com.prashant.users.microservice.DTOs.ResponseDto;
import com.prashant.users.microservice.DTOs.UserDto;
import com.prashant.users.microservice.Entities.User;
import com.prashant.users.microservice.Mapper.UserMapper;
import com.prashant.users.microservice.Repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Objects;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserServiceImpl implements IUserService {

    private UserRepository userRepository;

    @Override
    public ResponseEntity<ResponseDto> register(UserDto userDto) {
        User user = UserMapper.mapUserDtoToUser(userDto,new User());
        userRepository.save(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(new ResponseDto(MessageConstant.STATUS_201,MessageConstant.MESSAGE_SUCCESS,user));
    }

    @Override
    public ResponseEntity<ResponseDto> updateDetails(Long id, UserDto userDto) {
        User user = userRepository.findById(id).orElseThrow();

        Optional.ofNullable(userDto.getName()).ifPresent(user::setName);
        Optional.ofNullable(userDto.getEmail()).ifPresent(user::setEmail);
        Optional.ofNullable(userDto.getPhone()).ifPresent(user::setPhone);

        userRepository.save(user);
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseDto(MessageConstant.STATUS_200,String.format("User Details updated Successfully for ID : %d",id),null));
    }

    @Override
    public ResponseEntity<ResponseDto> disableAccount(Long id) {
        User user = userRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found"));;
        user.setIsActive(false);
        userRepository.save(user);
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseDto(MessageConstant.STATUS_200,String.format("Account Disabled Successfully for ID : %d",id),user));
    }
}
