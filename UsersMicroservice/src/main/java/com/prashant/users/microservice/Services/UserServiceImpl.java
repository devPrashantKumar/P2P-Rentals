package com.prashant.users.microservice.Services;

import com.prashant.users.microservice.Constants.MessageConstant;
import com.prashant.users.microservice.DTOs.ResponseDto;
import com.prashant.users.microservice.DTOs.UserDto;
import com.prashant.users.microservice.Entities.User;
import com.prashant.users.microservice.Exceptions.UserNotFoundException;
import com.prashant.users.microservice.Mapper.UserMapper;
import com.prashant.users.microservice.Repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static com.prashant.users.microservice.Constants.MessageConstant.*;

@Service
@AllArgsConstructor
public class UserServiceImpl implements IUserService {

    private UserRepository userRepository;

    public ResponseEntity<ResponseDto> user(UUID id) {
        User user = userRepository.findById(id).orElseThrow(() -> new UserNotFoundException("User not found for id: " + id));
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseDto(MessageConstant.STATUS_200,String.format(USER_DETAILS_FETCHED_SUCCESSFULLY_FOR_ID_S,id),user));
    }

    public ResponseEntity<ResponseDto> allUsers() {
       List<User> user = userRepository.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(ResponseDto.builder().statusCode(MessageConstant.STATUS_200).responseMessage(String.format(USER_DETAILS_FETCHED_SUCCESSFULLY)).responseData(user).build());
    }

    @Override
    public ResponseEntity<ResponseDto> register(UserDto userDto) {
        User user = UserMapper.mapUserDtoToUser(userDto,new User());
        userRepository.save(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(new ResponseDto(MessageConstant.STATUS_201,MessageConstant.MESSAGE_SUCCESS,user));
    }

    @Override
    public ResponseEntity<ResponseDto> updateDetails(UUID id, UserDto userDto) {
        User user = userRepository.findById(id).orElseThrow();

        Optional.ofNullable(userDto.getName()).ifPresent(user::setName);
        Optional.ofNullable(userDto.getEmail()).ifPresent(user::setEmail);
        Optional.ofNullable(userDto.getPhone()).ifPresent(user::setPhone);

        userRepository.save(user);
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseDto(MessageConstant.STATUS_200,String.format(USER_DETAILS_UPDATED_SUCCESSFULLY_FOR_ID_S,id),user));
    }

    @Override
    public ResponseEntity<ResponseDto> disableAccount(UUID id) {
        User user = userRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, USER_NOT_FOUND));;
        user.setIsActive(false);
        userRepository.save(user);
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseDto(MessageConstant.STATUS_200,String.format(ACCOUNT_DISABLED_SUCCESSFULLY_FOR_ID_S,id),user));
    }
}
