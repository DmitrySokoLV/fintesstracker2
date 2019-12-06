package com.example.fintesstracker2.controller;

import com.example.fintesstracker2.model.User;
import com.example.fintesstracker2.service.UserService;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    // это чтобы не светило красным
    public UserController() {
        userService = null;
    }


    @GetMapping
    public List<User> findAll() {
        return userService.findAll();
    }

    @GetMapping("/{id}")
    public User findById(@PathVariable long id) {
        return userService.findById(id);
    }

    @PostMapping
    public long create(@Valid @RequestBody User user) {
        return userService.createUser(user);
    }

    // сделал пример варианта для себя, чтобы разобраться
    @PutMapping("/{id}")
    public void update(@PathVariable long id) {
        User user = userService.findById(id);
        userService.updateUser(user);
    }


    @DeleteMapping("/{id}")
    public void removeUser(@PathVariable long id) {
        userService.removeUser(id);
    }
}