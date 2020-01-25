package com.example.fintesstracker2.dto;

import com.example.fintesstracker2.model.Training;
import lombok.Data;

import java.util.Set;

@Data
public class UserDTO {
    private long id;

    private String name;

    private String email;
    private String password;

    private double weight;

    private int height;

    private double bmi;

    private Set<Training> trainings;

}
