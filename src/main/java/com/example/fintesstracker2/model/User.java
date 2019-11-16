package com.example.fintesstracker2.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Data

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

    @OneToOne(mappedBy = "user",
    cascade = CascadeType.ALL,
    orphanRemoval = true)
    private Set<Training> trainings;
}
