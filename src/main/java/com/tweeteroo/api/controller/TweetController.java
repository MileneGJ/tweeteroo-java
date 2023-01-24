package com.tweeteroo.api.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
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

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/tweets")
public class TweetController {

    @Autowired
    private TweetService service;

    @GetMapping
    public ResponseEntity<List<Tweets>> listAll(@RequestParam("page") Optional<Integer> page) {
        List<Tweets> tweetsPage = service.getByPage(page);
        return ResponseEntity.ok().body(tweetsPage);
    }

    @GetMapping("/{username}")
    public ResponseEntity<List<Tweets>> listByUser(@PathVariable String username) {
        List<Tweets> tweetsPage = service.getByUsername(username);
        return ResponseEntity.ok().body(tweetsPage);
    }
    
    @PostMapping
    public ResponseEntity<String> createTweet(@RequestBody @Valid TweetDTO req) {
        service.createTweet(req);
        return ResponseEntity.ok("OK");
    }
}
