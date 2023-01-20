package com.tweeteroo.api.model;

import com.tweeteroo.api.dto.TweetDTO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
public class Tweets {

    public Tweets(TweetDTO data, String avatar) {
        this.username = data.username();
        this.tweet = data.tweet();
        this.avatar = avatar;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(length=50, nullable = false)
    private String username;
    @Column(length=255, nullable = false)
    private String avatar;
    @Column(length=255, nullable = false)
    private String tweet;
}
