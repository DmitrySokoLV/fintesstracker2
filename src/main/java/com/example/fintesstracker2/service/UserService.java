package com.example.fintesstracker2.service;

import com.example.fintesstracker2.model.User;

import java.util.List;

public interface UserService {

    public User findById();

    public List<User> findAll();

    public void createUser(User user);

    public void updateUser(User user);

    public void removeUser(Integer id);

    public double bmiCalculateBeforeTraining(User user);

    public double bmiCalculateAfterTraining(User user);
}
