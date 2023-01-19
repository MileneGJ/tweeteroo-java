package com.tweeteroo.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tweeteroo.api.dto.TweetDTO;
import com.tweeteroo.api.model.Tweets;
import com.tweeteroo.api.repository.TweetRepository;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/tweets")
public class TweetController {

    @Autowired
    private TweetRepository repository;

    @GetMapping("/{username}")
    public List<Tweets> listByUser(@PathVariable String username) {
        return repository.findByUsername(username);
    }
    
    @PostMapping
    public String createTweet(@RequestBody @Valid TweetDTO req) {
        repository.save(new Tweets(req));
        return "OK";
    }
}
