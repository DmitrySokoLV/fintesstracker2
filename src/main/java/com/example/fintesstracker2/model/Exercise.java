package com.example.fintesstracker2.model;

import com.example.fintesstracker2.model.enums.ExerciseType;
import lombok.Data;

import javax.persistence.*;

@Data

@Entity
@Table(name = "exercise")
public class Exercise {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    // тип упражнения
    @Enumerated(value = EnumType.STRING)
    private ExerciseType exerciseType;

    // кол-во повторений
    private int numberOfTimes;

    // кол-во подходов
    private int numberOfApproaches;
}