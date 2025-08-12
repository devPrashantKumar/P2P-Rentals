package com.prashant.bikes.microservice.Mapper;

import com.prashant.bikes.microservice.DTOs.BikeAvailabilityDto;
import com.prashant.bikes.microservice.Entities.BikeAvailability;

public class BikeAvailabilityMapper {
    public static BikeAvailability mapBikeAvailabilityDtoToBikeAvailability(BikeAvailabilityDto bikeAvailabilityDto){
        BikeAvailability bikeAvailability = new BikeAvailability();
        bikeAvailability.setBikeId(bikeAvailabilityDto.getBikeId());
        bikeAvailability.setAvailableFrom(bikeAvailabilityDto.getAvailableFrom());
        bikeAvailability.setAvailableTo(bikeAvailabilityDto.getAvailableTo());
        return bikeAvailability;
    }

    public static BikeAvailabilityDto mapBikeAvailabilityToBikeAvailabilityDto(BikeAvailability bikeAvailability){
        BikeAvailabilityDto bikeAvailabilityDto = new BikeAvailabilityDto();
        bikeAvailabilityDto.setBikeId(bikeAvailability.getBikeId());
        bikeAvailabilityDto.setAvailableFrom(bikeAvailability.getAvailableFrom());
        bikeAvailabilityDto.setAvailableTo(bikeAvailability.getAvailableTo());
        return bikeAvailabilityDto;
    }
}