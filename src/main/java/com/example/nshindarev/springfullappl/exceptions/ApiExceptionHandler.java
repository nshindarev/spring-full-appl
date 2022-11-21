package com.example.nshindarev.springfullappl.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.ZonedDateTime;

// allows to handle more than 1 exception
@ControllerAdvice // to be available all accross controllers
public class ApiExceptionHandler {

    // ResponseEntity<Object> is being used to build response to our client
    @ExceptionHandler(value = APIException.class)
    public ResponseEntity<Object> handleApiRequestException (APIRequestException e){
        APIException apiException = new APIException(
                e.getMessage(), e, HttpStatus.BAD_REQUEST, ZonedDateTime.now()
        );
        return new ResponseEntity<>(apiException, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = NotFoundException.class)
    public ResponseEntity<Object> handleNotFoundException (NotFoundException e){
        APIException notFoundException = new APIException(
                e.getMessage(), e, HttpStatus.NOT_FOUND, ZonedDateTime.now()
        );
        return new ResponseEntity<>(notFoundException, HttpStatus.BAD_REQUEST);
    }
}
