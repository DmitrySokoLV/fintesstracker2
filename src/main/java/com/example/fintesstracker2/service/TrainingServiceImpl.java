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
        return trainingRepository.findAll();
    }

    @Override
    public long createTraining(TrainingDTO trainingDto) {
        return trainingRepository.save(toTraining(trainingDto)).getId();
    }


    @Override
    public void updateTraining(long id, TrainingDTO trainingDto) {
        Training trainingFromRepository = findById(id);
        trainingFromRepository.setStatus(trainingDto.getStatus());
        trainingFromRepository.setDate(trainingDto.getDate());
        trainingFromRepository.setUser(trainingDto.getUser());
        trainingFromRepository.setExercises(trainingDto.getExercises());
        trainingRepository.save(trainingFromRepository);
    }

    @Override
    public void removeTraining(long id) {
        trainingRepository.delete(findById(id));
    }

    @Override
    public void changeStatus(long id, StatusTraining status) {
        Training trainingFromRepository = findById(id);
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
