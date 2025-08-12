package com.prashant.bikes.microservice.Services;

import com.prashant.bikes.microservice.DTOs.BikeAvailabilityDto;
import com.prashant.bikes.microservice.DTOs.ResponseDto;
import com.prashant.bikes.microservice.DTOs.BikeDto;
import org.springframework.http.ResponseEntity;

import java.util.UUID;

public interface IBikeService {

    public ResponseEntity<ResponseDto> bike(UUID id);

    public ResponseEntity<ResponseDto> allBikes();

    public ResponseEntity<ResponseDto> userOwnedBikes(UUID id);

    public ResponseEntity<ResponseDto> register(BikeDto bikeDto);

    public ResponseEntity<ResponseDto> addBikeAvailability(BikeAvailabilityDto bikeAvailabilityDto);

    public ResponseEntity<ResponseDto> updateDetails(UUID id, BikeDto bikeDto);

    public ResponseEntity<ResponseDto> disableAccount(UUID id);
}
