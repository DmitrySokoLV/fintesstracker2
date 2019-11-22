package com.example.fintesstracker2.model;


import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Data

@Entity
public class Training {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String status;

    @Column(name = "CREATED_DATE")
    private LocalDate date;

    // fetch = FetchType.EAGER - когда происходит тренировка, я буду получать инфу, какой пользователь ее делал
    @ManyToMany(fetch = FetchType.EAGER)
    //нужно для того чтобы в бд это поле было юзер айди, а не как по умолчанию = авто айди
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToMany(fetch = FetchType.EAGER)
    //нужно для того чтобы в бд это поле было юзер айди, а не как по умолчанию = авто айди
    @JoinColumn(name = "exercises_id", nullable = false)
    private List<Exercise> exercises;

    public Training() {}
}
