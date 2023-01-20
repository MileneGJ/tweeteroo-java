package com.tweeteroo.api.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tweeteroo.api.dto.TweetDTO;
import com.tweeteroo.api.model.Tweets;
import com.tweeteroo.api.repository.TweetRepository;

@Service
public class TweetService {

    @Autowired
    private TweetRepository repository;

    @Autowired
    private AuthorService authorService;

    public void createTweet(TweetDTO tweet) {
        String avatar = authorService.getUserAvatar(tweet.username());
        repository.save(new Tweets(tweet, avatar));
    }

    public List<Tweets> getByUsername(String username) {
        return repository.findByUsername(username);
    }

    public List<Tweets> getByPage(Optional<Integer> page) {
        return repository.findAll();
    }
    
}
