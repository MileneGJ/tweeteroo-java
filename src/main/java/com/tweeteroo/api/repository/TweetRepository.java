package com.tweeteroo.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tweeteroo.api.model.Tweets;

public interface TweetRepository extends JpaRepository<Tweets,Long>{
    
}
