package com.example.fintesstracker2.model;

import com.example.fintesstracker2.model.enums.TypesOfExercises;

public class Exercise {
    private TypesOfExercises typeOfExercises;
    private int numberOfTimes;
    private int numberOfApproaches = 4; // количество подходов ровняется 4 по умолчанию.
}
