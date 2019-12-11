package com.example.fintesstracker2.service;

import com.example.fintesstracker2.model.Training;
import com.example.fintesstracker2.model.enums.StatusTraining;

import java.util.List;

public interface TrainingService {

    public Training findById(long id);

    public List<Training> findAll();

    public long createTraining(Training training);

    public void updateTraining(Training training, long id);

    public void removeTraining(long id);

    public void changeStatus(long id, StatusTraining status);
}
