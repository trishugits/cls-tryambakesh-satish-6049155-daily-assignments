package com.example.demo.reposiories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.Trainee;

@Repository
public interface ITrainee extends JpaRepository<Trainee, Integer> {
	List<Trainee> findByTName(String name); 
}
