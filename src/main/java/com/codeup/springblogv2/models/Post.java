package com.codeup.springblogv2.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "posts")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(length = 150, nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT NOT NULL")
    private String body;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;


    public Post(String title, String body) {
        this.title = title;
        this.body = body;
    }
}
