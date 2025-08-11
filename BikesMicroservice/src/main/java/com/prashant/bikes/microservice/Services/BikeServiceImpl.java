package com.prashant.bikes.microservice.Services;

import com.prashant.bikes.microservice.Constants.MessageConstant;
import com.prashant.bikes.microservice.DTOs.ResponseDto;
import com.prashant.bikes.microservice.DTOs.BikeDto;
import com.prashant.bikes.microservice.Entities.Bike;
import com.prashant.bikes.microservice.Exceptions.BikeNotFoundException;
import com.prashant.bikes.microservice.Mapper.BikeMapper;
import com.prashant.bikes.microservice.Repositories.BikeRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static com.prashant.bikes.microservice.Constants.MessageConstant.*;

@Service
@AllArgsConstructor
public class BikeServiceImpl implements IBikeService {

    private BikeRepository bikeRepository;

    public ResponseEntity<ResponseDto> bike(UUID id) {
        Bike bike = bikeRepository.findById(id).orElseThrow(() -> new BikeNotFoundException(String.format(BIKE_NOT_FOUND_FOR_ID_S,id)));
        return ResponseEntity.status(HttpStatus.OK).body(ResponseDto.builder().statusCode(MessageConstant.STATUS_200).responseMessage(String.format(BIKE_DETAILS_FETCHED_SUCCESSFULLY_FOR_ID_S,id)).responseData(bike).build());
    }

    public ResponseEntity<ResponseDto> allBikes() {
        List<Bike> bike = bikeRepository.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(ResponseDto.builder().statusCode(MessageConstant.STATUS_200).responseMessage(String.format(BIKE_DETAILS_FETCHED_SUCCESSFULLY)).responseData(bike).build());
    }

    @Override
    public ResponseEntity<ResponseDto> userOwnedBikes(UUID id) {
        List<Bike> bikes = bikeRepository.findByOwnerId(id);
        return ResponseEntity.status(HttpStatus.OK).body(ResponseDto.builder().statusCode(MessageConstant.STATUS_200).responseMessage(String.format(BIKE_DETAILS_FETCHED_SUCCESSFULLY)).responseData(bikes).build());
    }

    @Override
    public ResponseEntity<ResponseDto> register(BikeDto bikeDto) {
        Bike bike = BikeMapper.mapUserDtoToUser(bikeDto,new Bike());
        bikeRepository.save(bike);
        return ResponseEntity.status(HttpStatus.CREATED).body(ResponseDto.builder().statusCode(MessageConstant.STATUS_201).responseMessage(MessageConstant.MESSAGE_SUCCESS).responseData(bike).build());
    }

    @Override
    public ResponseEntity<ResponseDto> updateDetails(UUID id, BikeDto bikeDto) {
        Bike bike = bikeRepository.findById(id).orElseThrow(() -> new BikeNotFoundException(String.format(BIKE_NOT_FOUND_FOR_ID_S,id)));

        Optional.ofNullable(bikeDto.getName()).ifPresent(bike::setName);
        //Optional.ofNullable(bikeDto.getEmail()).ifPresent(bike::setEmail);
        //Optional.ofNullable(bikeDto.getPhone()).ifPresent(bike::setPhone);

        bikeRepository.save(bike);
        return ResponseEntity.status(HttpStatus.OK).body(ResponseDto.builder().statusCode(MessageConstant.STATUS_200).responseMessage(String.format(BIKE_DETAILS_UPDATED_SUCCESSFULLY_FOR_ID_S,id)).responseData(bike).build());
    }

    @Override
    public ResponseEntity<ResponseDto> disableAccount(UUID id) {
        Bike bike = bikeRepository.findById(id).orElseThrow(() -> new BikeNotFoundException(String.format(BIKE_NOT_FOUND_FOR_ID_S,id)));
        bike.setIsActive(false);
        bikeRepository.save(bike);
        return ResponseEntity.status(HttpStatus.OK).body(ResponseDto.builder().statusCode(MessageConstant.STATUS_200).responseMessage(String.format(BIKE_DISABLED_SUCCESSFULLY_FOR_ID_S,id)).responseData(bike).build());
    }
}
