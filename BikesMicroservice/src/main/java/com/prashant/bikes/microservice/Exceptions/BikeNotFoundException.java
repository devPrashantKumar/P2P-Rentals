package com.prashant.bikes.microservice.Exceptions;

public class BikeNotFoundException extends RuntimeException{
    public BikeNotFoundException(String msg){
        super(msg);
    }
}
