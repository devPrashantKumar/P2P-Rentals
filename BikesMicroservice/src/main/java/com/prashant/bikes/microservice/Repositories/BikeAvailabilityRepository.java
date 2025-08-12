package com.prashant.bikes.microservice.Repositories;

import com.prashant.bikes.microservice.Entities.Bike;
import com.prashant.bikes.microservice.Entities.BikeAvailability;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface BikeAvailabilityRepository extends JpaRepository<BikeAvailability, UUID> {
}
