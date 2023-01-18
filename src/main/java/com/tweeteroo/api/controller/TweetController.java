package com.tweeteroo.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tweeteroo.api.dto.TweetDTO;
import com.tweeteroo.api.model.Tweets;
import com.tweeteroo.api.repository.TweetRepository;

@RestController
@RequestMapping("/tweets")
public class TweetController {

    @Autowired
    private TweetRepository repository;
    
    @PostMapping
    public String createTweet(@RequestBody TweetDTO req) {
        repository.save(new Tweets(req));
        return "OK";
    }
}
