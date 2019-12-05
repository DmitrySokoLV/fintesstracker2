package com.example.fintesstracker2.service;

import com.example.fintesstracker2.model.Training;
import com.example.fintesstracker2.model.enums.StatusTraining;

import java.util.List;

public interface TrainingService {

    public Training findById();

    public List<Training> findAll();

    public void createTraining(Training training);

    public void updateTraining(Training training);

    public void removeTraining(Integer id);

    public void changeStatus(Training training, StatusTraining status);
}
