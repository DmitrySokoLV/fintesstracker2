package com.example.fintesstracker2.service;

import com.example.fintesstracker2.model.Exercise;

import java.util.List;

public interface ExerciseService {

    public Exercise findById(long id);

    public List<Exercise> findAll();

    public long createExercise(Exercise exercise);

    public void updateExercise(Exercise exercise);

    public void removeExercise(long id);

    public void updateNumberOfTimes(long id, int numberOfTimes);

    public void updateNumberOfApproaches(long id, int numberOfApproaches);
}
