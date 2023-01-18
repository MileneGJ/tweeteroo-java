package com.tweeteroo.api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tweeteroo.api.dto.UserDTO;

@RestController
@RequestMapping("/user")
public class UserController {
    
    @GetMapping
    public String heySpring(){
        return "Hey Spring";
    }

    @PostMapping
    public String createUser(@RequestBody UserDTO req) {
        System.out.println("Creating "+req.name());
        return "OK";
    }
}
