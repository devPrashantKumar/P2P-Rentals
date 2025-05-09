package com.prashant.payments.microservice.Services;

import com.prashant.payments.microservice.Constants.MessageConstant;
import com.prashant.payments.microservice.DTOs.ResponseDto;
import com.prashant.payments.microservice.DTOs.UserDto;
import com.prashant.payments.microservice.Entities.User;
import com.prashant.payments.microservice.Mapper.UserMapper;
import com.prashant.payments.microservice.Repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

import static com.prashant.payments.microservice.Constants.MessageConstant.*;

@Service
@AllArgsConstructor
public class UserServiceImpl implements IUserService {

    private UserRepository userRepository;

    public ResponseEntity<ResponseDto> user(Long id) {
        User user = userRepository.findById(id).orElseThrow();
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseDto(MessageConstant.STATUS_200,String.format(USER_DETAILS_FETCHED_SUCCESSFULLY_FOR_ID_D,id),user));
    }

    public ResponseEntity<ResponseDto> allUsers() {
       List<User> user = userRepository.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseDto(MessageConstant.STATUS_200,String.format(USER_DETAILS_FETCHED_SUCCESSFULLY),user));
    }

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
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseDto(MessageConstant.STATUS_200,String.format(USER_DETAILS_UPDATED_SUCCESSFULLY_FOR_ID_D,id),user));
    }

    @Override
    public ResponseEntity<ResponseDto> disableAccount(Long id) {
        User user = userRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, USER_NOT_FOUND));;
        user.setIsActive(false);
        userRepository.save(user);
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseDto(MessageConstant.STATUS_200,String.format(ACCOUNT_DISABLED_SUCCESSFULLY_FOR_ID_D,id),user));
    }
}
