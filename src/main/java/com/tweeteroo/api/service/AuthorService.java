package com.tweeteroo.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tweeteroo.api.dto.AuthorDTO;
import com.tweeteroo.api.model.Author;
import com.tweeteroo.api.repository.AuthorRepository;

@Service
public class AuthorService {

    @Autowired
    private AuthorRepository repository;

    public String getUserAvatar(String name) {
        List<Author> foundAuthor = repository.findByName(name);
        return foundAuthor.get(0).getAvatar();
    }

    public void createUser(AuthorDTO author) {
        repository.save(new Author(author));
    }
    
}
