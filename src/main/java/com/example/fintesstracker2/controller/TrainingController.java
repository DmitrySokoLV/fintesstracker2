package com.example.fintesstracker2.controller;

import com.example.fintesstracker2.dto.TrainingDTO;
import com.example.fintesstracker2.model.Training;
import com.example.fintesstracker2.repository.UserRepository;
import com.example.fintesstracker2.service.TrainingService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/training")
@RequiredArgsConstructor
public class TrainingController {

    private final TrainingService trainingService;
    private final UserRepository userRepository;

    @GetMapping
    public List<TrainingDTO> findAll() {
        return trainingService.findAll()
                .stream()
                .map(TrainingController::toTrainingDTO)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public TrainingDTO findById(@PathVariable long id) {
        return toTrainingDTO(trainingService.findById(id));
    }

    @PostMapping
    public long create(@RequestBody TrainingDTO trainingDto) {
        return trainingService.createTraining(trainingDto);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable long id, @RequestBody TrainingDTO trainingDto) {
        trainingService.updateTraining(id, trainingDto);
    }

    @DeleteMapping("/{id}")
    public void removeUser(@PathVariable long id) {
        trainingService.removeTraining(id);
    }

    private static TrainingDTO toTrainingDTO(Training training) {
        TrainingDTO dto = new TrainingDTO();

        dto.setId(training.getId());
        dto.setStatus(training.getStatus());
        dto.setDate(training.getDate());
        dto.setId(training.getId());
        dto.setExercises(training.getExercises());

        return dto;
    }
}
