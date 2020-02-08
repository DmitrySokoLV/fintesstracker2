package com.example.fintesstracker2.dto;

import com.example.fintesstracker2.model.Exercise;
import com.example.fintesstracker2.model.enums.StatusTraining;
import lombok.Data;

import java.time.LocalDate;
import java.util.Set;

@Data
public class TrainingDTO {
    private long id;

    private StatusTraining status;

    private LocalDate date;

    private long user_id;

    private Set<Exercise> exercises;
}
