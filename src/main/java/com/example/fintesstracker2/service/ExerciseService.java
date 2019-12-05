package com.example.fintesstracker2.service;

import com.example.fintesstracker2.model.Exercise;
import com.example.fintesstracker2.model.User;
import com.example.fintesstracker2.model.enums.ExerciseType;

import java.util.List;

public interface ExerciseService {

    public Exercise findById();

    public List<Exercise> findAll();

    public void createUser(Exercise exercise);

    public void updateUser(Exercise exercise);

    public void removeUser(Integer id);

    public void changeExercise(Exercise exercise, ExerciseType exerciseType);
}
