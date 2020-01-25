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

    private final static double MIN_BMI = 25;
    private final static double PERCENT = 100.0;
    private final static int VALUE_TO_THE_FORMULA = 2;

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
        userFromRepository.setId(userDto.getId());
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

        userFromRepository.setBmi(Math.max(newBmi, MIN_BMI));

        userRepository.save(userFromRepository);

        return newBmi;
    }

    private double bmiCalculate(double weight, int height) {
        return weight / Math.pow(height / PERCENT, VALUE_TO_THE_FORMULA);
    }


    private static User toUser(UserDTO userDTO) {
        User user = new User();

        user.setId(userDTO.getId());
        user.setName(userDTO.getName());
        user.setEmail(userDTO.getEmail());
        user.setPassword(userDTO.getPassword());
        user.setWeight(userDTO.getWeight());
        user.setHeight(userDTO.getHeight());
        user.setBmi(userDTO.getBmi());
        user.setTrainings(userDTO.getTrainings());

        return user;
    }
}
