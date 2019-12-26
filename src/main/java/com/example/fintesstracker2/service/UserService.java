package com.example.fintesstracker2.service;

import com.example.fintesstracker2.dto.UserDTO;
import com.example.fintesstracker2.model.User;

import java.util.List;

public interface UserService {

    User findById(long id);

    List<User> findAll();

    long createUser(UserDTO userDto);

    void updateUser(long id, UserDTO userDto);

    void removeUser(long id);

    double bmiCalculate(long id, double weight, int height);

    double updateBMI(long id, double bmi);
}
