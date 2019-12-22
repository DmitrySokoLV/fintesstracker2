package com.example.fintesstracker2.service;

import com.example.fintesstracker2.dto.TrainingDTO;
import com.example.fintesstracker2.model.Training;
import com.example.fintesstracker2.model.enums.StatusTraining;

import java.util.List;

public class TrainingServiceImpl implements TrainingService {
    @Override
    public TrainingDTO findById(long id) {
        return null;
    }

    @Override
    public List<TrainingDTO> findAll() {
        return null;
    }

    @Override
    public long createTraining(TrainingDTO trainingDto) {
        return 0;
    }

    @Override
    public void updateTraining(TrainingDTO trainingDto, long id) {

    }

    @Override
    public void removeTraining(long id) {

    }

    @Override
    public void changeStatus(long id, StatusTraining status) {

    }

    private static TrainingDTO toTrainingDTO(Training training) {
        TrainingDTO dto = new TrainingDTO();

        dto.setStatus(training.getStatus());
        dto.setDate(training.getDate());
        dto.setUser(training.getUser());
        dto.setExercises(training.getExercises());

        return dto;
    }

    private static Training toTraining(TrainingDTO trainingDTO) {
        Training training = new Training();

        training.setStatus(trainingDTO.getStatus());
        training.setDate(trainingDTO.getDate());
        training.setUser(trainingDTO.getUser());
        training.setExercises(trainingDTO.getExercises());

        return training;
    }
}
