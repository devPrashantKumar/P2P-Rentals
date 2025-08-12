package com.prashant.bikes.microservice.DTOs;

import com.prashant.bikes.microservice.Enums.BikeType;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BikeAvailabilityDto {
    private UUID bikeId;
    private LocalDateTime availableFrom;
    private LocalDateTime availableTo;
}
