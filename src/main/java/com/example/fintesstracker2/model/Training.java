package com.example.fintesstracker2.model;


import com.example.fintesstracker2.model.enums.StatusTraining;
import lombok.Data;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.time.LocalDate;
import java.util.Set;

@Data

@Entity
@Table(name = "training")
public class Training {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Enumerated(value = EnumType.STRING)
    private StatusTraining status;

    @Column(name = "created_date")
    private LocalDate date;

    // fetch = FetchType.EAGER - когда происходит тренировка, я буду получать инфу, какой пользователь ее делал
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    //нужно для того чтобы в бд это поле было юзер айди, а не как по умолчанию = авто айди
    @JoinColumn(name = "user_id", nullable = false)
    private User user;


    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "training_exercises",
            joinColumns = @JoinColumn(name = "training_id", nullable = false),
            inverseJoinColumns = @JoinColumn(name = "exercise_id", nullable = false))
    private Set<Exercise> exercises;
}
