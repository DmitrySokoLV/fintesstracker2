package com.example.fintesstracker2.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.Clock;
import java.time.LocalDateTime;

@ControllerAdvice
public class ApiExceptionHandler {

    private  static final Logger logger = LoggerFactory.getLogger(ApiExceptionHandler.class);

    @ExceptionHandler(value = {NotFoundException.class})
    public ResponseEntity<Object> notFoundApiRequestException(NotFoundException exception) {
        logger.info("Worked not found exception ", exception);
        ApiException apiException = new ApiException(
                exception.getMessage(),
                LocalDateTime.now(Clock.systemUTC())
        );
        return new ResponseEntity<>(apiException, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = {BadRequestException.class})
    public ResponseEntity<Object> badRequestException(BadRequestException exception) {
        logger.info("Bad request ", exception);
        ApiException apiException = new ApiException(
                exception.getMessage(),
                LocalDateTime.now(Clock.systemUTC())
        );
        return new ResponseEntity<>(apiException, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = {NullPointerException.class})
    public ResponseEntity<Object> nullPointerException(NullPointerException exception) {
        logger.info("Null pointer ", exception);
        ApiException apiException = new ApiException(
                exception.getMessage(),
                LocalDateTime.now(Clock.systemUTC())
        );
        return new ResponseEntity<>(apiException, HttpStatus.BAD_GATEWAY);
    }


}
