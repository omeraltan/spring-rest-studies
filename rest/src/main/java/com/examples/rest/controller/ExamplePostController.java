package com.examples.rest.controller;

import com.examples.rest.service.BookService;
import com.examples.rest.utility.ResponseTransfer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.awt.*;

@Controller
@RequestMapping("/post")
public class ExamplePostController {

    @Autowired
    BookService service;

    @PostMapping("/response")
    @ResponseBody
    public ResponseTransfer postResponseController(@RequestBody String loginForm){
        return new ResponseTransfer("Thanks For Posting!!!");
    }

    @PostMapping(value = "/content", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseTransfer postResponseJsonContent(@RequestBody String s){
        return new ResponseTransfer("JSON Content!");
    }

    @PostMapping(value = "/contente", produces = MediaType.APPLICATION_XML_VALUE)
    @ResponseBody
    public ResponseTransfer postResponsexMLcontent(@RequestBody String st){
        return new ResponseTransfer("XML Content!");
    }

}
