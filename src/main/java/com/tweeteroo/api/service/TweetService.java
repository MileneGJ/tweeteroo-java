package com.tweeteroo.api.service;

import java.util.ArrayList;
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
        List<Tweets> allTweets = repository.findAll();
        int lengthTweets = allTweets.size();
        if(lengthTweets>5){
            List<Tweets> clipedTweets = new ArrayList<>();
            int initialTweet = lengthTweets -1;
            if(page.isPresent()) initialTweet = lengthTweets -1 - (page.get()-1)*5;
            for(int i=0; i<5; i++){
                if((initialTweet-i)>=0){
                clipedTweets.add(allTweets.get(initialTweet-i));
                } else {
                clipedTweets.add(allTweets.get(0));
                break;
                }
            }
            return clipedTweets;
        } else {
        return allTweets;
        }
    }
    
}
