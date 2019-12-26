package com.example.fintesstracker2.service;

import com.example.fintesstracker2.dto.ExerciseDTO;
import com.example.fintesstracker2.model.Exercise;

import java.util.List;

public interface ExerciseService {

    Exercise findById(long id);

    List<Exercise> findAll();

    long createExercise(ExerciseDTO exerciseDto);

    void updateExercise(long id, ExerciseDTO exerciseDto);

    void removeExercise(long id);

    void updateNumberOfTimes(long id, int numberOfTimes);

    void updateNumberOfApproaches(long id, int numberOfApproaches);
}
