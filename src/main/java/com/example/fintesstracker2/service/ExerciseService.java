package com.example.fintesstracker2.service;

import com.example.fintesstracker2.dto.ExerciseDTO;
import com.example.fintesstracker2.model.Exercise;
import com.example.fintesstracker2.model.Training;

import java.util.List;

public interface ExerciseService {

    public Exercise findById(long id);

    public List<Exercise> findAll();

    public long createExercise(ExerciseDTO exerciseDto);

    public void updateExercise(long id, ExerciseDTO exerciseDto);

    public void removeExercise(long id);

    public void updateNumberOfTimes(long id, int numberOfTimes);

    public void updateNumberOfApproaches(long id, int numberOfApproaches);
}
