package com.example.fintesstracker2.service;

import com.example.fintesstracker2.dto.TrainingDTO;
import com.example.fintesstracker2.model.Training;
import com.example.fintesstracker2.model.enums.StatusTraining;

import java.util.List;

public interface TrainingService {

    public Training findById(long id);

    public List<Training> findAll();

    public long createTraining(TrainingDTO trainingDto);

    public void updateTraining(long id, TrainingDTO trainingDto);

    public void removeTraining(long id);

    public void changeStatus(long id, StatusTraining status);
}
