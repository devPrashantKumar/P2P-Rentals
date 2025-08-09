package com.prashant.users.microservice.ControllerAdvices;

import com.prashant.users.microservice.DTOs.ErrorResponseDto;
import com.prashant.users.microservice.Exceptions.UserNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalExceptionHandler {

    // Handle UserNotFoundException
    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<ErrorResponseDto> handleUserNotFound(
            UserNotFoundException ex,
            HttpServletRequest request
    ) {
        ErrorResponseDto response = ErrorResponseDto.builder()
                .apiPath(request.getRequestURI())
                .errorCode(Integer.toString(HttpStatus.NOT_FOUND.value()))
                .errorMessage(ex.getMessage())
                .errorTime(LocalDateTime.now())
                .build();

        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

    // Handle all other exceptions
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponseDto> handleGenericException(Exception ex, HttpServletRequest request) {
        ErrorResponseDto response = ErrorResponseDto.builder()
                .apiPath(request.getRequestURI())
                .errorCode(Integer.toString(HttpStatus.INTERNAL_SERVER_ERROR.value()))
                .errorMessage(ex.getMessage())
                .errorTime(LocalDateTime.now())
                .build();
        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
