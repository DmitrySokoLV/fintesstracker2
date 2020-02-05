package com.example.fintesstracker2.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.Clock;
import java.time.LocalDateTime;

@ControllerAdvice
public class ApiExceptionHandler {

    @ExceptionHandler(value = {NotFoundException.class})
    public ResponseEntity<Object> handleApiRequestException(NotFoundException exception) {
        ApiException apiException = new ApiException(
                exception.getMessage(),
                exception,
                LocalDateTime.now(Clock.systemUTC())
        );
        return new ResponseEntity<>(apiException, HttpStatus.NOT_FOUND);
    }


}
