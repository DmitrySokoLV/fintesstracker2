package com.example.fintesstracker2.controller;

import com.example.fintesstracker2.dto.UserDTO;
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

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private UserService userService;

    private UserDTO userDto;

    @GetMapping
    public List<UserDTO> findAll() {
        return userService.findAll();
    }

    @GetMapping("/{id}")
    public UserDTO findById(@PathVariable long id) {
        return userService.findById(id);
    }

    @PostMapping
    public long create(@RequestBody UserDTO userDto) {
        return userService.createUser(userDto);
    }

    // сделал пример варианта для себя, чтобы разобраться
    @PutMapping("/{id}")
    public void update(@PathVariable long id, UserDTO userDto) {
        userService.updateUser(userDto, id);
    }

    @DeleteMapping("/{id}")
    public void removeUser(@PathVariable long id) {
        userService.removeUser(id);
    }

}