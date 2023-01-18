package com.tweeteroo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tweeteroo.api.model.User;

public interface UserRepository extends JpaRepository<User,Long>{
    
}
