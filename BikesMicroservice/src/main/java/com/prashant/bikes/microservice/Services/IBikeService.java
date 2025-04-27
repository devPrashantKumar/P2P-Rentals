package com.prashant.bikes.microservice.Services;

import com.prashant.bikes.microservice.DTOs.ResponseDto;
import com.prashant.bikes.microservice.DTOs.BikeDto;
import org.springframework.http.ResponseEntity;

public interface IBikeService {

    public ResponseEntity<ResponseDto> bike(Long id);

    public ResponseEntity<ResponseDto> allBikes();

    public ResponseEntity<ResponseDto> userOwnedBikes(Long id);

    public ResponseEntity<ResponseDto> register(BikeDto bikeDto);

    public ResponseEntity<ResponseDto> updateDetails(Long id, BikeDto bikeDto);

    public ResponseEntity<ResponseDto> disableAccount(Long id);
}
