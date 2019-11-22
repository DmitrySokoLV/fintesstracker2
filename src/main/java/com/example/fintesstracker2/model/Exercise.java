package com.example.fintesstracker2.model;

import com.example.fintesstracker2.model.enums.ExerciseType;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data

@Entity
public class Exercise {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    // тип упражнения
    private ExerciseType exerciseType;

    // кол-во повторений
    private int numberOfTimes;

    // кол-во подходов
    private int numberOfApproaches;

    public Exercise() {}
}