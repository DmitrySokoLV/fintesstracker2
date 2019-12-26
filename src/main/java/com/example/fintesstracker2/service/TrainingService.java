package com.example.fintesstracker2.service;

import com.example.fintesstracker2.dto.TrainingDTO;
import com.example.fintesstracker2.model.Training;
import com.example.fintesstracker2.model.enums.StatusTraining;

import java.util.List;

public interface TrainingService {

    Training findById(long id);

    List<Training> findAll();

    long createTraining(TrainingDTO trainingDto);

    void updateTraining(long id, TrainingDTO trainingDto);

    void removeTraining(long id);

    void changeStatus(long id, StatusTraining status);
}
