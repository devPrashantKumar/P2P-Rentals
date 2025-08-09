package com.prashant.users.microservice.Constants;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access= AccessLevel.PRIVATE)
public class MessageConstant {
    public static final String STATUS_200 = "200";
    public static final String STATUS_201 = "201";
    public static final String MESSAGE_500 = "An Error Occurred, Please try again or contact Dev Team";
    public static final String MESSAGE_SUCCESS = "Request Processed Successfully";
    public static final String ACCOUNT_DISABLED_SUCCESSFULLY_FOR_ID_S = "Account Disabled Successfully for ID : %s";
    public static final String USER_NOT_FOUND = "User not found";
    public static final String USER_DETAILS_UPDATED_SUCCESSFULLY_FOR_ID_S = "User Details updated Successfully for ID : %s";
    public static final String USER_DETAILS_FETCHED_SUCCESSFULLY = "User Details fetched Successfully";
    public static final String USER_DETAILS_FETCHED_SUCCESSFULLY_FOR_ID_S = "User Details fetched Successfully for ID : %s";
}
