package com.example.fintesstracker2.model;

import com.example.fintesstracker2.model.enums.ExerciseType;
import lombok.Data;

@Data
public class Exercise {

    // тип упражнения
    private ExerciseType exerciseType;
    // кол-во повторений
    private int numberOfTimes;
    // кол-во подходов
    private int numberOfApproaches;

}
