package com.examples.rest.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;

import java.net.InetSocketAddress;
import java.util.Map;
import java.util.stream.Collectors;

@Controller
public class HeaderController {

    @GetMapping("/greeting") // http://localhost:8080/greeting Headers: Accept-Language : tr
    public ResponseEntity<String> greeting(@RequestHeader(HttpHeaders.ACCEPT_LANGUAGE) String language){
        return new ResponseEntity<>(language, HttpStatus.OK);
    }

    @GetMapping("/double") // http://localhost:8080/double Headers: my-number Value: 12 pretty: 12 * 2 = 24
    public ResponseEntity<String> doubleNumber(@RequestHeader("my-number") int myNumber){
        return new ResponseEntity<String>(String.format("%d * 2 = %d", myNumber, (myNumber * 2)), HttpStatus.OK);
    }

    @GetMapping("/listHeader") // http://localhost:8080/listHeader
    public ResponseEntity<String> listAllHeaders(@RequestHeader Map<String, String> headers){
        headers.forEach((key,value) -> {
            System.out.println(String.format("Header '%s' = %s", key, value));
        });

        return new ResponseEntity<String>(String.format("Listed %d headers", headers.size()), HttpStatus.OK);
    }

    @GetMapping("/multiValue") // http://localhost:8080/multiValue
    public ResponseEntity<String> multiValue(@RequestHeader MultiValueMap<String, String> headers){
        headers.forEach((key,value) -> {
            System.out.println(String.format("Header '%s'",key,value.stream().collect(Collectors.joining("|"))));
        });
        return new ResponseEntity<String>(String.format("Listed %d headers", headers.size()), HttpStatus.OK);
    }

    @GetMapping("/getBaseUrl") // http://localhost:8080/getBaseUrl
    public ResponseEntity<String> getBaseUrl(@RequestHeader HttpHeaders headers){
        InetSocketAddress host = headers.getHost();
        String url = "http://" + host.getHostName() + ":" + host.getPort();
        return new ResponseEntity<String>(String.format("Base URL = %s", url), HttpStatus.OK);
    }

    @GetMapping("/nonRequiredHeader")
    public ResponseEntity<String> evaluateNonRequiredHeader(@RequestHeader(value = "optional-header", required = false) String optionalHeader){
        return new ResponseEntity<String>(String.format("Was the optional header present? %s", (optionalHeader == null ? "No" : "Yes")), HttpStatus.OK);
    }

    @GetMapping("/default")
    public ResponseEntity<String> evaluateDefaultHeaderValue(@RequestHeader(value = "optional-header", defaultValue = "3600") int optionalHeader){
        return new ResponseEntity<String>(String.format("Optional Header is %d", optionalHeader), HttpStatus.OK);
    }
}
