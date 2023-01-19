package com.tweeteroo.api.dto;

import jakarta.validation.constraints.NotBlank;

public record AuthorDTO(
    @NotBlank
    String name,
    @NotBlank 
    String avatar) {
    
}
