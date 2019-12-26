package com.example.fintesstracker2.service;

import com.example.fintesstracker2.dto.UserDTO;
import com.example.fintesstracker2.model.User;

import java.util.List;

public interface UserService {

    public User findById(long id);

    public List<User> findAll();

    public long createUser(UserDTO userDto);

    public void updateUser(long id, UserDTO userDto);

    public void removeUser(long id);

    public double bmiCalculate(long id, double weight, int height);

    public double updateBMI(long id, double bmi);
}
