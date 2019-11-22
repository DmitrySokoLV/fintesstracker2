package com.example.fintesstracker2.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Data

// entity сущность, которая необходима сохранять в базе данных
@Entity

// @Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    private double weight;
    private int height;

    // индекс массы тела
    private double bms;

    @OneToMany(mappedBy = "user_training", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    private Set<Training> trainings;

    public User() {}
}
