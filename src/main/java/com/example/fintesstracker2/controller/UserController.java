package com.example.fintesstracker2.controller;

import com.example.fintesstracker2.dto.UserDTO;
import com.example.fintesstracker2.model.User;
import com.example.fintesstracker2.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping
    public List<UserDTO> findAll() {
        return userService.findAll()
                .stream()
                .map(UserController::toUserDTO)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public UserDTO findById(@PathVariable long id) {
        return toUserDTO(userService.findById(id));
    }

    @PostMapping
    public long create(@RequestBody UserDTO userDto) {
        return userService.createUser(userDto);
    }


    @PutMapping("/{id}")
    public void update(@PathVariable long id, UserDTO userDto) {
        userService.updateUser(id, userDto);
    }

    @DeleteMapping("/{id}")
    public void removeUser(@PathVariable long id) {
        userService.removeUser(id);
    }

    private static UserDTO toUserDTO(User user) {
        UserDTO dto = new UserDTO();

        dto.setName(user.getName());
        dto.setEmail(user.getEmail());
        dto.setPassword(user.getPassword());
        dto.setWeight(user.getWeight());
        dto.setHeight(user.getHeight());
        dto.setBmi(user.getBmi());
        dto.setTrainings(user.getTrainings());

        return dto;
    }

}