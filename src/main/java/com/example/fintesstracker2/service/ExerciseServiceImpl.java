package com.example.fintesstracker2.service;

import com.example.fintesstracker2.dto.ExerciseDTO;
import com.example.fintesstracker2.model.Exercise;

import java.util.List;

public class ExerciseServiceImpl implements ExerciseService{
    @Override
    public ExerciseDTO findById(long id) {
        return null;
    }

    @Override
    public List<ExerciseDTO> findAll() {
        return null;
    }

    @Override
    public long createExercise(ExerciseDTO exerciseDto) {
        return 0;
    }

    @Override
    public void updateExercise(ExerciseDTO exerciseDto, long id) {

    }

    @Override
    public void removeExercise(long id) {

    }

    @Override
    public void updateNumberOfTimes(long id, int numberOfTimes) {

    }

    @Override
    public void updateNumberOfApproaches(long id, int numberOfApproaches) {

    }

    private static ExerciseDTO toExerciseDTO(Exercise exercise) {
        ExerciseDTO dto = new ExerciseDTO();

        dto.setExerciseType(exercise.getExerciseType());
        dto.setNumberOfTimes(exercise.getNumberOfTimes());
        dto.setNumberOfApproaches(exercise.getNumberOfApproaches());

        return dto;
    }

    private static Exercise toExercise(ExerciseDTO exerciseDTO) {
        Exercise exercise = new Exercise();

        exercise.setExerciseType(exerciseDTO.getExerciseType());
        exercise.setNumberOfTimes(exerciseDTO.getNumberOfTimes());
        exercise.setNumberOfApproaches(exerciseDTO.getNumberOfApproaches());

        return exercise;
    }
}