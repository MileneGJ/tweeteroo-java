package com.tweeteroo.api.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tweeteroo.api.dto.TweetDTO;

@RestController
@RequestMapping("/tweets")
public class TweetController {
    
    @PostMapping
    public String createTweet(@RequestBody TweetDTO req) {
        System.out.println(req.tweet());
        return "OK";
    }
}
