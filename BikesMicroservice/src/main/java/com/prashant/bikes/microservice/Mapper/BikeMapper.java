package com.prashant.bikes.microservice.Mapper;

import com.prashant.bikes.microservice.DTOs.BikeDto;
import com.prashant.bikes.microservice.Entities.Bike;

public class BikeMapper {
    public static Bike mapUserDtoToUser(BikeDto bikeDto, Bike bike){
        bike.setBikeType(bikeDto.getBikeType());
        bike.setBrand(bikeDto.getBrand());
        bike.setName(bikeDto.getName());
        bike.setModel(bikeDto.getModel());
        bike.setHourlyRate(bikeDto.getHourlyRate());
        bike.setIsAvailable(bikeDto.getIsAvailable());
        bike.setOwnerId(bikeDto.getOwnerId());
        return bike;
    }

    public static BikeDto mapUserToUserDto(Bike bike, BikeDto bikeDto){
        bikeDto.setBikeType(bike.getBikeType());
        bikeDto.setBrand(bike.getBrand());
        bikeDto.setName(bike.getName());
        bikeDto.setModel(bike.getModel());
        bikeDto.setHourlyRate(bike.getHourlyRate());
        bikeDto.setIsAvailable(bike.getIsAvailable());
        bikeDto.setOwnerId(bike.getOwnerId());
        return bikeDto;
    }
}