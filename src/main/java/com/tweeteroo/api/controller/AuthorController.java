package com.tweeteroo.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tweeteroo.api.dto.AuthorDTO;
import com.tweeteroo.api.model.Author;
import com.tweeteroo.api.repository.AuthorRepository;

@RestController
@RequestMapping("/sign-up")
public class AuthorController {

    @Autowired
    private AuthorRepository repository;
    
    @GetMapping
    public String heySpring(){
        return "Hey Spring";
    }

    @PostMapping
    public String createUser(@RequestBody AuthorDTO req) {
        repository.save(new Author(req));
        return "OK";
    }
}
