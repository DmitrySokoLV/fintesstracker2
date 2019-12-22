package com.example.fintesstracker2.service;

import com.example.fintesstracker2.dto.ExerciseDTO;

import java.util.List;

public interface ExerciseService {

    public ExerciseDTO findById(long id);

    public List<ExerciseDTO> findAll();

    public long createExercise(ExerciseDTO exerciseDto);

    public void updateExercise(ExerciseDTO exerciseDto, long id);

    public void removeExercise(long id);

    public void updateNumberOfTimes(long id, int numberOfTimes);

    public void updateNumberOfApproaches(long id, int numberOfApproaches);
}
