package com.example.fintesstracker2.controller;

import com.example.fintesstracker2.dto.ExerciseDTO;
import com.example.fintesstracker2.model.Exercise;
import com.example.fintesstracker2.service.ExerciseService;
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
@RequestMapping("/exercise")
@RequiredArgsConstructor
public class ExerciseController {

    private ExerciseService exerciseService;

    private ExerciseDTO exerciseDto;

    @GetMapping
    public List<ExerciseDTO> findAll() { return exerciseService.findAll()
            .stream()
            .map(ExerciseController::toExerciseDTO)
            .collect(Collectors.toList()); }

    @GetMapping("/{id}")
    public ExerciseDTO findById(@PathVariable long id) { return toExerciseDTO(exerciseService.findById(id)); }

    @PostMapping
    public long create(@RequestBody ExerciseDTO exerciseDto) {return exerciseService.createExercise(exerciseDto); }

    @PutMapping("/{id}")
    public void update(@PathVariable long id, ExerciseDTO exerciseDto) { exerciseService.updateExercise(id, exerciseDto); }

    @DeleteMapping("/{id")
    public void delete(@PathVariable long id) {exerciseService.removeExercise(id);}

    private static ExerciseDTO toExerciseDTO(Exercise exercise) {
        ExerciseDTO dto = new ExerciseDTO();

        dto.setExerciseType(exercise.getExerciseType());
        dto.setNumberOfTimes(exercise.getNumberOfTimes());
        dto.setNumberOfApproaches(exercise.getNumberOfApproaches());

        return dto;
    }
}
