package com.example.fintesstracker2.service;

import com.example.fintesstracker2.model.User;

import java.util.List;

public interface UserService {

    public User findById(long id);

    public List<User> findAll();

    public long createUser(User user);

    public void updateUser(User user);

    public void removeUser(long id);

    public double bmiCalculate(long id, double weight, int height);

    public double updateBMI(long id, double bmi);
}
