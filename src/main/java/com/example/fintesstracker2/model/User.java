package com.example.fintesstracker2.model;

import lombok.Data;

import java.util.Set;

@Data
public class User {

    private int id;
    private String name;
    private double weight;
    private int height;

    // индекс массы тела
    private double bms;
    private Set<Training> trainings;

}
