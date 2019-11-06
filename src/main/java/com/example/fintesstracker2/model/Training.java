package com.example.fintesstracker2.model;


import lombok.Data;

import java.util.Calendar;

@Data
public class Training {
    private String status; // или лучше statusOfTraining?
    private Calendar calendar; // или использовать тут класс Data
    // упражнения коллекция
    private User user;
}
