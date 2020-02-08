package com.example.fintesstracker2.service;

import com.example.fintesstracker2.dto.TrainingDTO;
import com.example.fintesstracker2.exception.BadRequestException;
import com.example.fintesstracker2.exception.NotFoundException;
import com.example.fintesstracker2.model.Training;
import com.example.fintesstracker2.model.User;
import com.example.fintesstracker2.model.enums.StatusTraining;
import com.example.fintesstracker2.repository.TrainingRepository;
import com.example.fintesstracker2.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TrainingServiceImpl implements TrainingService {

    private final TrainingRepository trainingRepository;
    private final UserRepository userRepository;

    @Override
    public Training findById(long id) {
        if (id < 0) {
            throw new BadRequestException("Incorrect id");
        }

        return trainingRepository.findById(id).orElseThrow(() -> new NotFoundException("Training not found"));
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

        User user = userRepository.getOne(trainingDto.getUser_id());
        trainingFromRepository.setUser(user);

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


    private Training toTraining(TrainingDTO trainingDTO) {
        Training training = new Training();
        User user = userRepository.getOne(trainingDTO.getUser_id());

        training.setStatus(trainingDTO.getStatus());
        training.setDate(trainingDTO.getDate());
        training.setUser(user);
        training.setExercises(trainingDTO.getExercises());

        return training;
    }
}
