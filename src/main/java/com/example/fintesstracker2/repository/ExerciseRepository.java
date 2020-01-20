package com.example.fintesstracker2.repository;

import com.example.fintesstracker2.model.Exercise;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExerciseRepository extends JpaRepository<Exercise, Long> {
}