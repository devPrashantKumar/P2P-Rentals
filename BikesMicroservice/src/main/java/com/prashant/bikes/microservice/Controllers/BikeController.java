package com.prashant.bikes.microservice.Controllers;

import com.prashant.bikes.microservice.DTOs.BikeDto;
import com.prashant.bikes.microservice.DTOs.ResponseDto;
import com.prashant.bikes.microservice.Services.IBikeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path="/api",produces = MediaType.APPLICATION_JSON_VALUE)
public class BikeController {
    public static final Logger LOGGER = LoggerFactory.getLogger(BikeController.class);

    @Autowired
    private IBikeService bikeService;

    @Value("${spring.application.name}")
    private String applicationName;

    @GetMapping("/health-check")
    public String sayHello(){
        LOGGER.info("HealthCheck API called");
        return String.format("Hello %s is UP and Running",applicationName);
    }

    @GetMapping("/bike/{id}")
    public ResponseEntity<ResponseDto> bike(@PathVariable("id") Long id){
        return this.bikeService.bike(id);
    }

    @GetMapping("/bikes")
    public ResponseEntity<ResponseDto> allBikes(){
        return this.bikeService.allBikes();
    }

    @GetMapping("/user-owned-bikes/{id}")
    public ResponseEntity<ResponseDto> userOwnedBikes(@PathVariable("id") Long id){
        return this.bikeService.userOwnedBikes(id);
    }

    @PostMapping("/register")
    public ResponseEntity<ResponseDto> register(@RequestBody BikeDto bikeDto){
        return this.bikeService.register(bikeDto);
    }

    @PutMapping("/update-details/{id}")
    public ResponseEntity<ResponseDto> updateDetails(@PathVariable("id") Long id, @RequestBody BikeDto bikeDto){
        return this.bikeService.updateDetails(id,bikeDto);
    }

    @DeleteMapping("/disable-account/{id}")
    public ResponseEntity<ResponseDto> disableAccount(@PathVariable("id") Long id){
        return this.bikeService.disableAccount(id);
    }
}
