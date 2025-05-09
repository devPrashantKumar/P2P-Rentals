package com.prashant.bikes.microservice.Repositories;

import com.prashant.bikes.microservice.Entities.Bike;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface BikeRepository extends JpaRepository<Bike, Long> {

    List<Bike> findByOwnerId(Long id);
}
