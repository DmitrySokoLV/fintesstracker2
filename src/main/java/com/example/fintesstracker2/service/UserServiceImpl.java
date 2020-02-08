package com.example.fintesstracker2.service;

import com.example.fintesstracker2.dto.UserDTO;
import com.example.fintesstracker2.exception.BadRequestException;
import com.example.fintesstracker2.exception.NotFoundException;
import com.example.fintesstracker2.model.User;
import com.example.fintesstracker2.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private static final double MIN_BMI = 25;
    private static final double PERCENT = 100.0;
    private static final int VALUE_TO_THE_FORMULA = 2;
    private static final double FOR_DECIMAL_ROUNDING_FORMULA = 100d;

    private final UserRepository userRepository;

    @Override
    public User findById(long id) {

        if (id < 0) {
            throw new BadRequestException("Incorrect id");
        }

        return userRepository.findById(id).orElseThrow(() -> new NotFoundException("User not found"));
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

        userFromRepository.setBmi(Math.max(newBmi, MIN_BMI));

        userRepository.save(userFromRepository);

        return newBmi;
    }

    // ошибку деления на ноль, если пользователь введет ноль
    private double bmiCalculate(double weight, int height) {

        double result = weight / Math.pow(height / PERCENT, VALUE_TO_THE_FORMULA);

        if (result == 0) {
            throw new NullPointerException("Division by zero error. you entered incorrect data");
        }

        return Math.round((result * FOR_DECIMAL_ROUNDING_FORMULA) / FOR_DECIMAL_ROUNDING_FORMULA);

    }


    private User toUser(UserDTO userDTO) {
        User user = new User();

        user.setName(userDTO.getName());
        user.setEmail(userDTO.getEmail());
        user.setPassword(userDTO.getPassword());
        user.setWeight(userDTO.getWeight());
        user.setHeight(userDTO.getHeight());
        user.setBmi(bmiCalculate(user.getWeight(), user.getHeight()));
        user.setTrainings(userDTO.getTrainings());

        return user;
    }
}
