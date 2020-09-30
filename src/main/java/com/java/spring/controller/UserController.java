package com.java.spring.controller;

import java.util.List;
import java.util.Map;

import com.java.spring.entity.Item;
import com.java.spring.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    // @GetMapping(value = "/list" )
    // public ResponseEntity<Object> getUserDetails(){
    // return new ResponseEntity<>(userService.getUserDetails() , HttpStatus.OK);
    // }

    // @PostMapping(value = "/post")
    // public ResponseEntity<Object> postUser(@RequestBody Map<String, String> map){
    // return new ResponseEntity<>(userService.postUser(map.get("name")) ,
    // HttpStatus.OK);
    // }

    @GetMapping(value = "hello-world")
    public String helloWorld() {
        return "Hello World";
    }

    @GetMapping(value = "/dummy-item")
    public Item getItem() {
        return new Item(123, "Indarpreet", 120, 2);
    }

    @GetMapping(value = "/dummy-item-service")
    public Item getItemFromService() {
        return userService.getItem();
    }

    @GetMapping(value = "/dummy-item-service-repo")
    public List<Item> getItemFromServiceRepo() {
        return userService.getItemFromRepo();
    }
}
