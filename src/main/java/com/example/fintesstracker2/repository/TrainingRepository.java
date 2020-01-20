package com.example.fintesstracker2.repository;

import com.example.fintesstracker2.model.Training;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TrainingRepository extends JpaRepository<Training, Long> {
}