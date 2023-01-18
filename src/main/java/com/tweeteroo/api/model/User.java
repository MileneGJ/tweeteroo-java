package com.tweeteroo.api.model;

import com.tweeteroo.api.dto.UserDTO;

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
public class User {

    public User(UserDTO data){
        this.avatar = data.avatar();
        this.name = data.name();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(length=50,nullable = false)
     String name;
    @Column(nullable = false)
     String avatar;
}
