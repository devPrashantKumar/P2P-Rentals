package com.prashant.bikes.microservice.Constants;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access= AccessLevel.PRIVATE)
public class MessageConstant {
    public static final String STATUS_200 = "200";
    public static final String STATUS_201 = "201";
    public static final String MESSAGE_500 = "An Error Occurred, Please try again or contact Dev Team";
    public static final String MESSAGE_SUCCESS = "Request Processed Successfully";
    public static final String BIKE_DISABLED_SUCCESSFULLY_FOR_ID_D = "Bike Disabled Successfully for ID : %d";
    public static final String BIKE_NOT_FOUND = "Bike not found";
    public static final String BIKE_DETAILS_UPDATED_SUCCESSFULLY_FOR_ID_D = "Bike Details updated Successfully for ID : %d";
    public static final String BIKE_DETAILS_FETCHED_SUCCESSFULLY = "Bike Details fetched Successfully";
    public static final String BIKE_DETAILS_FETCHED_SUCCESSFULLY_FOR_ID_D = "Bike Details fetched Successfully for ID : %d";
}
