package com.tweeteroo.api.model;

import com.tweeteroo.api.dto.AuthorDTO;

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
public class Author {

    public Author(AuthorDTO data){
        this.avatar = data.avatar();
        this.name = data.name();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(length=50,nullable = false)
    private String name;

    @Column(length=255, nullable = false)
    private String avatar;
}
