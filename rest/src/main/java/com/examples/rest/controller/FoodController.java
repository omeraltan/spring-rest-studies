package com.examples.rest.controller;

import com.examples.rest.entity.Food;
import com.examples.rest.service.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import static org.springframework.web.bind.annotation.RequestMethod.*;

@Controller
public class FoodController {

    @Autowired
    FoodService service;

    @RequestMapping(value = "/food", method = GET)
    @ResponseBody
    public String getFoodBySimplePath(){
        return "Get some Food";
    }

    @RequestMapping(value = "/food/ex", headers = "key=val", method = GET)
    @ResponseBody
    public String getFoodWithHeader(){
        return "Get some Food with Header";
    }

    @RequestMapping(value = "/food/{id}", method = GET) // http://localhost:8080/food/10
    @ResponseBody
    public Optional<Food> getFoodBySimplePathWithPathVariable(@PathVariable("id") long id){
        return service.findById(id);
    }

    @RequestMapping(value = "/food/{foodid}/type/{typeid}", method = GET) // http://localhost:8080/food/10/type/4
    @ResponseBody
    public Optional<Food> getFoodBySimplePathVariables(@PathVariable(value = "foodid") Long id, @PathVariable(value = "typeid") Integer type ){
        return service.findByIdAndType(id, type);
    }

    @RequestMapping(value = "/food/regex/{id:[\\d]+}", method = GET) // http://localhost:8080/food/regex/10
    @ResponseBody
    public Optional<Food> getFoodsBySimplePathWithPathVariable(@PathVariable Long id){
        return service.findById(id);
    }

    @RequestMapping(value = "/food/params", method = GET) // http://localhost:8080/food/params?id=9
    @ResponseBody
    public Optional<Food> getFoodBySimplePathWithRequestParam(@RequestParam("id") long id){
        return service.findById(id);
    }

    @RequestMapping(value = "/food/explicit", params = "id", method = GET) // http://localhost:8080/food/explicit?id=9
    @ResponseBody
    public Optional<Food> getFoodBySimplePathWithExplicitRequestParam(@RequestParam("id") long id){
        return service.findById(id);
    }

    @RequestMapping(value = "/food/type", params = {"id", "type"}, method = GET) // http://localhost:8080/food/type?id=3&type=1
    @ResponseBody
    public Optional<Food> getFoodBySimplePathWithExplicitRequestParams(@RequestParam("id") long id){
        return service.findById(id);
    }

    // http://localhost:8080/food/advanced?id=3     // http://localhost:8080/book/advanced?id=3
    @RequestMapping(value = {"/food/advanced", "/book/advanced"}, method = GET)
    @ResponseBody
    public Optional<Food> getFoodOrBooksByPath(@RequestParam("id") long id){
        return service.findById(id);
    }

    // POST
    /**
     *
     * {
     *     "id": null,
     *     "name": "pankek",
     *     "type": 5,
     *     "price": 11.22
     * }
     *
     */
    // PUT
    /**
     *
     * {
     *     "id": 10,
     *     "name": "pankek",
     *     "type": 5,
     *     "price": 11.22
     * }
     *
     */
    @RequestMapping(value = "/food/multiple", method = {PUT, POST}) // http://localhost:8080/food/multiple
    @ResponseBody
    public Optional<Food> putAndPostFood(@RequestBody Food food){
        return service.save(food);
    }

    // a Fallback for All Requests
    @RequestMapping(value = "*", method = GET) // http://localhost:8080/wq, http://localhost:8080/wavhttp://localhost:8080/*
    @ResponseBody
    public List<Food> getFallback(){
        return service.findAll();
    }

    // or even for all requests
    @RequestMapping(value = "*", method = {GET,POST,PUT,PATCH}) // http://localhost:8080/wq, http://localhost:8080/wavhttp://localhost:8080/*
    @ResponseBody
    public List<Food> allFallback(){
        return service.findAll();
    }

    @ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Some parameters are invalid about xml value")
    @GetMapping(value = "/food/duplicate", produces = MediaType.APPLICATION_XML_VALUE)
    public List<Food> duplicateXml(){
        return service.findAll();
    }

    @ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Some parameters are invalid")
    @GetMapping(value = "/food/duplicate", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Food> duplicateJson(){
        return service.findAll();
    }





}
