package com.prashant.bikes.microservice.DTOs;

import com.prashant.bikes.microservice.Enums.BikeType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BikeDto {
    private String name;
    private UUID ownerId;
    private String model;
    private String brand;
    private BikeType bikeType;
    private Double hourlyRate;
    private Boolean isAvailable;
}
