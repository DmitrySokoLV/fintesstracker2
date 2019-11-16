package com.example.fintesstracker2.model;


import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Data

@Entity
public class Training {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String status;

    @Column(name = "CREATED_DATE")
    private LocalDate date;

    @ManyToOne
    private User user;

    private List<Exercise> exercises;
}
