package com.example.fintesstracker2.dto;

import com.example.fintesstracker2.model.Exercise;
import com.example.fintesstracker2.model.enums.StatusTraining;
import lombok.Data;

import javax.persistence.Id;
import java.time.LocalDate;
import java.util.Set;

@Data
public class TrainingDto {

    @Id
    private long id;

    private StatusTraining status;

    private LocalDate date;

    private UserDto user;

    private Set<Exercise> exercises;
}
