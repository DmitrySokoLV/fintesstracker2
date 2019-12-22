package com.example.fintesstracker2.controller;

import com.example.fintesstracker2.dto.TrainingDTO;
import com.example.fintesstracker2.service.TrainingService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/training")
@RequiredArgsConstructor
public class TrainingController {

    private TrainingService trainingService;

    private TrainingDTO trainingDto;

    @GetMapping
    public List<TrainingDTO> findAll() {return trainingService.findAll();}

    @GetMapping("/{id}")
    public TrainingDTO findById(@PathVariable long id) {return trainingService.findById(id);}

    @GetMapping
    public long create(@RequestBody TrainingDTO trainingDto) {return trainingService.createTraining(trainingDto); }

    @PutMapping("/{id}")
    public void update(@PathVariable long id, TrainingDTO trainingDto) { trainingService.updateTraining(trainingDto, id);}

    @DeleteMapping("/{id}")
    public void removeUser(@PathVariable long id) {trainingService.removeTraining(id);}

}
