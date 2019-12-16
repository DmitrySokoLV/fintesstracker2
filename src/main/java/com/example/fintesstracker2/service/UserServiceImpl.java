package com.example.fintesstracker2.service;

import com.example.fintesstracker2.dto.UserDto;
import com.example.fintesstracker2.model.User;

import java.util.List;

public class UserServiceImpl implements UserService {
    @Override
    public UserDto findById(long id) {
        return null;
    }

    @Override
    public List<UserDto> findAll() {
        return null;
    }

    @Override
    public long createUser(UserDto userDto) {
        return 0;
    }

    @Override
    public void updateUser(UserDto userDto, long id) {

    }

    @Override
    public void removeUser(long id) {

    }

    @Override
    public double bmiCalculate(long id, double weight, int height) {
        return 0;
    }

    @Override
    public double updateBMI(long id, double bmi) {
        return 0;
    }

}
