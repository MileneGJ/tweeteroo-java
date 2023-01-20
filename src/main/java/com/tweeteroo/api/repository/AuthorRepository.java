package com.tweeteroo.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tweeteroo.api.model.Author;

public interface AuthorRepository extends JpaRepository<Author,Long>{
    List<Author> findByName(String name);
}
