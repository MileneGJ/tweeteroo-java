package com.tweeteroo.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tweeteroo.api.dto.AuthorDTO;
import com.tweeteroo.api.service.AuthorService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/sign-up")
public class AuthorController {

    @Autowired
    private AuthorService service;

    @PostMapping
    public String createUser(@RequestBody @Valid AuthorDTO req) {
        service.createUser(req);
        return "OK";
    }
}
