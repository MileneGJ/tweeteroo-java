package com.tweeteroo.api.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tweeteroo.api.dto.TweetDTO;
import com.tweeteroo.api.model.Tweets;
import com.tweeteroo.api.service.TweetService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/tweets")
public class TweetController {

    @Autowired
    private TweetService service;

    @GetMapping
    public List<Tweets> listAll(@RequestParam("page") Optional<Integer> page) {
        return service.getByPage(page);
    }

    @GetMapping("/{username}")
    public List<Tweets> listByUser(@PathVariable String username) {
        return service.getByUsername(username);
    }
    
    @PostMapping
    public String createTweet(@RequestBody @Valid TweetDTO req) {
        service.createTweet(req);
        return "OK";
    }
}
