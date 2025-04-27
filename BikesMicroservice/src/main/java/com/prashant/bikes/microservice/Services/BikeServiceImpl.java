package com.prashant.bikes.microservice.Services;

import com.prashant.bikes.microservice.Constants.MessageConstant;
import com.prashant.bikes.microservice.DTOs.ResponseDto;
import com.prashant.bikes.microservice.DTOs.BikeDto;
import com.prashant.bikes.microservice.Entities.Bike;
import com.prashant.bikes.microservice.Mapper.BikeMapper;
import com.prashant.bikes.microservice.Repositories.BikeRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

import static com.prashant.bikes.microservice.Constants.MessageConstant.*;

@Service
@AllArgsConstructor
public class BikeServiceImpl implements IBikeService {

    private BikeRepository bikeRepository;

    public ResponseEntity<ResponseDto> bike(Long id) {
        Bike bike = bikeRepository.findById(id).orElseThrow();
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseDto(MessageConstant.STATUS_200,String.format(BIKE_DETAILS_FETCHED_SUCCESSFULLY_FOR_ID_D,id),bike));
    }

    public ResponseEntity<ResponseDto> allBikes() {
        List<Bike> bike = bikeRepository.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseDto(MessageConstant.STATUS_200, String.format(BIKE_DETAILS_FETCHED_SUCCESSFULLY), bike));
    }

    @Override
    public ResponseEntity<ResponseDto> userOwnedBikes(Long id) {
        List<Bike> bikes = bikeRepository.findByOwnerId(id);
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseDto(MessageConstant.STATUS_200, String.format(BIKE_DETAILS_FETCHED_SUCCESSFULLY), bikes));
    }

    @Override
    public ResponseEntity<ResponseDto> register(BikeDto bikeDto) {
        Bike bike = BikeMapper.mapUserDtoToUser(bikeDto,new Bike());
        bikeRepository.save(bike);
        return ResponseEntity.status(HttpStatus.CREATED).body(new ResponseDto(MessageConstant.STATUS_201,MessageConstant.MESSAGE_SUCCESS,bike));
    }

    @Override
    public ResponseEntity<ResponseDto> updateDetails(Long id, BikeDto bikeDto) {
        Bike bike = bikeRepository.findById(id).orElseThrow();

        Optional.ofNullable(bikeDto.getName()).ifPresent(bike::setName);
        //Optional.ofNullable(bikeDto.getEmail()).ifPresent(bike::setEmail);
        //Optional.ofNullable(bikeDto.getPhone()).ifPresent(bike::setPhone);

        bikeRepository.save(bike);
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseDto(MessageConstant.STATUS_200,String.format(BIKE_DETAILS_UPDATED_SUCCESSFULLY_FOR_ID_D,id),bike));
    }

    @Override
    public ResponseEntity<ResponseDto> disableAccount(Long id) {
        Bike bike = bikeRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, BIKE_NOT_FOUND));;
        bike.setIsActive(false);
        bikeRepository.save(bike);
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseDto(MessageConstant.STATUS_200,String.format(BIKE_DISABLED_SUCCESSFULLY_FOR_ID_D,id),bike));
    }
}
