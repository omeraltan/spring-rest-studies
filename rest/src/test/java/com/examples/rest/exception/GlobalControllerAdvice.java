package com.examples.rest.exception;

import com.examples.rest.controller.CustomException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice
public class GlobalControllerAdvice {

    @ExceptionHandler(CustomException.class)
    public ResponseEntity<String> handleException(CustomException e){
        return new ResponseEntity<>("Custom Exception occurred: " + e.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(CustomException.class)
    public ResponseEntity<String> handle2Exception(CustomException e){
        return new ResponseEntity<>("Custom ıNTERNAL Exception occurred: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }


}
