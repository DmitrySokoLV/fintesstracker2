package com.example.fintesstracker2.model;


import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Data

@Entity
@Table(name = "training")
public class Training {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String status;

    @Column(name = "created_date")
    private LocalDate date;

    // fetch = FetchType.EAGER - когда происходит тренировка, я буду получать инфу, какой пользователь ее делал
    @OneToMany(fetch = FetchType.LAZY)
    //нужно для того чтобы в бд это поле было юзер айди, а не как по умолчанию = авто айди
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    // вот тут считаю что надо использовать каскад алл
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "training_exercises",
            joinColumns = @JoinColumn(name = "training_id", nullable = false),
            inverseJoinColumns = @JoinColumn(name = "exercise_id", nullable = false))
    private List<Exercise> exercises;

    public Training() {}
}
