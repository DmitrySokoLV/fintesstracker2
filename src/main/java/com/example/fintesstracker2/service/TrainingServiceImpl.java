package com.example.fintesstracker2.service;

import com.example.fintesstracker2.dto.TrainingDTO;
import com.example.fintesstracker2.model.Training;
import com.example.fintesstracker2.model.enums.StatusTraining;
import com.example.fintesstracker2.repository.TrainingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TrainingServiceImpl implements TrainingService {

    private final TrainingRepository trainingRepository;

    @Override
    public Training findById(long id) {
        return trainingRepository.findById(id).orElseThrow(() -> new RuntimeException("Training not found"));
    }

    @Override
    public List<Training> findAll() {
        return (List<Training>) trainingRepository.findAll();
    }

    @Override
    public long createTraining(TrainingDTO trainingDto) {
        return trainingRepository.save(toTraining(trainingDto)).getId();
    }


    @Override
    public void updateTraining(long id, TrainingDTO trainingDto) {
        Training trainingFromRepository = trainingRepository.findById(id).orElseThrow(() -> new RuntimeException("Training not found"));
        Training updateTraining = toTraining(trainingDto);
        updateTraining.setId(trainingFromRepository.getId());
        trainingRepository.save(updateTraining);
    }

    @Override
    public void removeTraining(long id) {
        trainingRepository.deleteById(id);
    }

    @Override
    public void changeStatus(long id, StatusTraining status) {
        Training trainingFromRepository = trainingRepository.findById(id).orElseThrow(() -> new RuntimeException("Training not found"));
        trainingFromRepository.setStatus(status);
        trainingRepository.save(trainingFromRepository);
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
