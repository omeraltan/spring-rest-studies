package com.examples.rest.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;

@Controller
public class ResponseEntityController {

    @GetMapping("/hello")
    ResponseEntity<String> hello(){
        return new ResponseEntity<>("Hello World!", HttpStatus.OK);
    }

    @GetMapping("/age") // http://localhost:8080/age?yearOfBirth=1984
    ResponseEntity<String> age(@RequestParam("yearOfBirth") int yearOfBirth){
        if (isInFuture(yearOfBirth)){
            return new ResponseEntity<>("Year of birth cannot be in the future", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>("You age is " + calculateAge(yearOfBirth), HttpStatus.OK);
    }

    @GetMapping("/customHeader")
    ResponseEntity<String> customHeader(){
        HttpHeaders headers = new HttpHeaders();
        headers.add("Custom-Header", "foo");

        return new ResponseEntity<>("Custom header set", headers, HttpStatus.OK);
    }

    @GetMapping("/hello2")
    ResponseEntity<String> hello2(){
        return ResponseEntity.ok("Hello World!");
    }

    private int calculateAge(int yearOfBirth) {
        return (LocalDate.now().getYear() - yearOfBirth);
    }

    private boolean isInFuture(int yearOfBirth) {
        if (yearOfBirth > LocalDate.now().getYear()){
            return true;
        }else {
            return false;
        }
    }


}
