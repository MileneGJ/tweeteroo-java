package com.tweeteroo.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tweeteroo.api.dto.UserDTO;
import com.tweeteroo.api.model.User;
import com.tweeteroo.repository.UserRepository;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserRepository repository;
    
    @GetMapping
    public String heySpring(){
        return "Hey Spring";
    }

    @PostMapping
    public String createUser(@RequestBody UserDTO req) {
        repository.save(new User(req));
        return "OK";
    }
}
