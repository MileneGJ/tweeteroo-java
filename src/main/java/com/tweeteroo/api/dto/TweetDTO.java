package com.tweeteroo.api.dto;

import jakarta.validation.constraints.NotBlank;

public record TweetDTO(
    @NotBlank
    String username,
    @NotBlank 
    String tweet) {
    
}
