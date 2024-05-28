package org.pack.platformeaide.model;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Setter
@Getter
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String password;

    @OneToMany(mappedBy = "user")
    private Set<Question> questions;


    @OneToMany(mappedBy = "user")
    private Set<Comment> comments;

    public User() {
    }
}
