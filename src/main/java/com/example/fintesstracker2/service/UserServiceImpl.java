package com.example.fintesstracker2.service;

import com.example.fintesstracker2.dto.UserDTO;
import com.example.fintesstracker2.model.User;

import java.util.List;

public class UserServiceImpl implements UserService {
    @Override
    public UserDTO findById(long id) {
        return null;
    }

    @Override
    public List<UserDTO> findAll() {
        return null;
    }

    @Override
    public long createUser(UserDTO userDto) {
        return 0;
    }

    @Override
    public void updateUser(UserDTO userDto, long id) {

    }

    @Override
    public void removeUser(long id) { }

    @Override
    public double bmiCalculate(long id, double weight, int height) {
        return 0;
    }

    @Override
    public double updateBMI(long id, double bmi) {
        return 0;
    }

    private static UserDTO toUserDTO(User user) {
        UserDTO dto = new UserDTO();

        dto.setName(user.getName());
        dto.setWeight(user.getWeight());
        dto.setHeight(user.getHeight());
        dto.setBmi(user.getBmi());
        dto.setTrainings(user.getTrainings());

        return dto;
    }

    private static User toUser(UserDTO userDTO) {
        User user = new User();

        user.setName(userDTO.getName());
        user.setWeight(userDTO.getWeight());
        user.setHeight(userDTO.getHeight());
        user.setBmi(userDTO.getBmi());
        user.setTrainings(userDTO.getTrainings());

        return user;
    }
}
