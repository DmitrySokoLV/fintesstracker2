package com.example.fintesstracker2.model;

import lombok.Data;

@Data
class User {
    private int id;
    private String name;
    private int weight;
    private int height;
    private double BMS; // индекс массы тела

}
