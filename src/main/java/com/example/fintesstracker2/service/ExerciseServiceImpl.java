package com.example.fintesstracker2.service;

import com.example.fintesstracker2.dto.ExerciseDTO;
import com.example.fintesstracker2.model.Exercise;
import com.example.fintesstracker2.repository.ExerciseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ExerciseServiceImpl implements ExerciseService{

    private final ExerciseRepository exerciseRepository;

    @Override
    public Exercise findById(long id) {
        return exerciseRepository.findById(id).orElseThrow(() -> new RuntimeException("Exercise not found"));
    }

    @Override
    public List<Exercise> findAll() {
        return (List<Exercise>) exerciseRepository.findAll();
    }

    @Override
    public long createExercise(ExerciseDTO exerciseDto) {
        return exerciseRepository.save(toExercise(exerciseDto)).getId();
    }

    @Override
    public void updateExercise(long id, ExerciseDTO exerciseDto) {
        Exercise exerciseFromRepository = exerciseRepository.findById(id).orElseThrow(() -> new RuntimeException("Exercise not found"));
        Exercise updateExercise = toExercise(exerciseDto);
        updateExercise.setId(exerciseFromRepository.getId());
        exerciseRepository.save(updateExercise);
    }

    @Override
    public void removeExercise(long id) {
        exerciseRepository.deleteById(id);
    }

    @Override
    public void updateNumberOfTimes(long id, int numberOfTimes) {

    }

    @Override
    public void updateNumberOfApproaches(long id, int numberOfApproaches) {

    }

    private static Exercise toExercise(ExerciseDTO exerciseDTO) {
        Exercise exercise = new Exercise();

        exercise.setExerciseType(exerciseDTO.getExerciseType());
        exercise.setNumberOfTimes(exerciseDTO.getNumberOfTimes());
        exercise.setNumberOfApproaches(exerciseDTO.getNumberOfApproaches());

        return exercise;
    }
}