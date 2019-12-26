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

    private final UserRepository userRepository;

    @Override
    public User findById(long id) {
        return userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
    }

    @Override
    public List<User> findAll() {
        return (List<User>) userRepository.findAll();
    }

    @Override
    public long createUser(UserDTO userDto) {
        return userRepository.save(toUser(userDto)).getId();
    }

    @Override
    public void updateUser(long id, UserDTO userDto) {
        User userFromRepository = userRepository.findById(id).orElseThrow(() -> new RuntimeException("Subscriber not found"));
        User updateUser = toUser(userDto);
        updateUser.setId(userFromRepository.getId());
        userRepository.save(updateUser);
    }

    @Override
    public void removeUser(long id) { userRepository.deleteById(id);}

    @Override
    public double bmiCalculate(long id, double weight, int height) {
        return 0;
    }

    @Override
    public double updateBMI(long id, double bmi) {
        return 0;
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
