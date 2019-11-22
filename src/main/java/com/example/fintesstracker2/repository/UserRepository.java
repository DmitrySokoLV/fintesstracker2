package com.example.fintesstracker2.repository;

import com.example.fintesstracker2.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> { }