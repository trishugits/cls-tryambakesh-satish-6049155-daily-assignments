package com.example.demo;


import java.util.List;
import java.util.Optional;

import com.example.demo.entities.Trainee;

public interface ITraineeSerivces {
	List<Trainee> fetchAll();
	List<Trainee> fetchByName(String name);
	Optional<Trainee> fetchById(int id);
	void deleteById(int id);
	void updateTrainee(Trainee tr);
	void addTrainee(Trainee tr);
}
