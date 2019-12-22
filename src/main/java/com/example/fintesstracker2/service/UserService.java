package com.example.fintesstracker2.service;

import com.example.fintesstracker2.dto.UserDTO;

import java.util.List;

public interface UserService {

    public UserDTO findById(long id);

    public List<UserDTO> findAll();

    public long createUser(UserDTO userDto);

    public void updateUser(UserDTO userDto, long id);

    public void removeUser(long id);

    public double bmiCalculate(long id, double weight, int height);

    public double updateBMI(long id, double bmi);
}
