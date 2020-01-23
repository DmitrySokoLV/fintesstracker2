package com.example.fintesstracker2.service;

import com.example.fintesstracker2.dto.UserDTO;
import com.example.fintesstracker2.model.User;
import com.example.fintesstracker2.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private static final int MIN_BMI_INDEX = 25;
    private static final double PERCENTS_100 = 100.0;

    private final UserRepository userRepository;

    @Override
    public User findById(long id) {
        return userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public long createUser(UserDTO userDto) {
        return userRepository.save(toUser(userDto)).getId();
    }

    @Override
    public void updateUser(long id, UserDTO userDto) {
        User userFromRepository = findById(id);
        userFromRepository.setName(userDto.getName());
        userFromRepository.setWeight(userDto.getWeight());
        userFromRepository.setHeight(userDto.getHeight());
        userFromRepository.setBmi(userDto.getBmi());
        userFromRepository.setTrainings(userDto.getTrainings());
        userRepository.save(userFromRepository);
    }

    @Override
    public void removeUser(long id) {
        userRepository.delete(findById(id));
    }

    @Override
    public double updateBMI(long id) {
        User userFromRepository = findById(id);
        double newBmi = bmiCalculate(userFromRepository.getWeight(), userFromRepository.getHeight());

        userFromRepository.setBmi(Math.max(newBmi, MIN_BMI_INDEX));

        userRepository.save(userFromRepository);

        return newBmi;
    }

    private static double bmiCalculate(double weight, int height) {
        return weight / Math.pow(height / PERCENTS_100, 2);
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
