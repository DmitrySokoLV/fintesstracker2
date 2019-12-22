package com.example.fintesstracker2.dto;

import com.example.fintesstracker2.model.Training;
import lombok.Data;

import javax.persistence.Id;
import java.util.Set;

@Data
public class UserDTO {

    @Id
    private long id;

    private String name;

    private double weight;

    private int height;

    private double bmi;

    private Set<Training> trainings;

}
