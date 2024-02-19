package com.examples.rest.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HeaderController {

    @GetMapping("/double") // http://localhost:8080/double Headers: my-number Value: 12 pretty: 12 * 2 = 24
    public ResponseEntity<String> doubleNumber(@RequestHeader("my-number") int myNumber){
        return new ResponseEntity<String>(String.format("%d * 2 = %d", myNumber, (myNumber * 2)), HttpStatus.OK);
    }


}
