package com.examples.rest.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping("/controller1")
    public String controller1(){
        throw new CustomException("tEST DENEME 123");
    }

}
