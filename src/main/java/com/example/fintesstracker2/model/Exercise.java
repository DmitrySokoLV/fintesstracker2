package com.example.fintesstracker2.model;

import com.example.fintesstracker2.model.enums.ExerciseType;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Data

@Entity
@Table(name = "exercise")
public class Exercise {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    // тип упражнения
    @Enumerated(value = EnumType.STRING)
    private ExerciseType exerciseType;

    // кол-во повторений
    private int numberOfTimes;

    // кол-во подходов
    private int numberOfApproaches;
}