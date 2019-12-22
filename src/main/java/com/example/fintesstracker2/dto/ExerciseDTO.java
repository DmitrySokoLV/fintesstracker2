package com.example.fintesstracker2.dto;

import com.example.fintesstracker2.model.enums.ExerciseType;
import lombok.Data;

import javax.persistence.Id;

@Data
public class ExerciseDTO {

    @Id
    private long id;

    private ExerciseType exerciseType;

    private int numberOfTimes;

    private int numberOfApproaches;
}