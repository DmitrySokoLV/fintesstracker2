package com.example.fintesstracker2.service;

import com.example.fintesstracker2.dto.UserDto;

import java.util.List;

public interface UserService {

    public UserDto findById(long id);

    public List<UserDto> findAll();

    public long createUser(UserDto userDto);

    public void updateUser(UserDto userDto, long id);

    public void removeUser(long id);

    public double bmiCalculate(long id, double weight, int height);

    public double updateBMI(long id, double bmi);
}
