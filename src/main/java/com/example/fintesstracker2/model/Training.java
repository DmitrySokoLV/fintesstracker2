package com.example.fintesstracker2.model;


import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class Training {

    private String status;
    private LocalDate date;
    private User user;
    private List<Exercise> exercises;

}
