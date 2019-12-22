package com.example.fintesstracker2.service;

import com.example.fintesstracker2.dto.TrainingDTO;
import com.example.fintesstracker2.model.enums.StatusTraining;

import java.util.List;

public interface TrainingService {

    public TrainingDTO findById(long id);

    public List<TrainingDTO> findAll();

    public long createTraining(TrainingDTO trainingDto);

    public void updateTraining(TrainingDTO trainingDto, long id);

    public void removeTraining(long id);

    public void changeStatus(long id, StatusTraining status);
}
