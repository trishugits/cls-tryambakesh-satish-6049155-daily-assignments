package com.example.demo;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Trainee;
import com.example.demo.reposiories.ITrainee;

@Service
public class TraineeServices implements ITraineeSerivces {

	@Autowired
	private ITrainee iTrainee;
	
	@Override
	public List<Trainee> fetchAll() {
		List<Trainee> list = iTrainee.findAll();
		return list;
	}

	@Override
	public List<Trainee> fetchByName(String name) {
		List<Trainee> list = iTrainee.findByTName(name);
		return list;
	}

	@Override
	public Optional<Trainee> fetchById(int id) {
	    return iTrainee.findById(id);
	}

	@Override
	public void deleteById(int id) {
		iTrainee.deleteById(id);
		
	}

	@Override
	public void updateTrainee(Trainee tr) {
		iTrainee.save(tr);
		
	}

	@Override
	public void addTrainee(Trainee tr) {
		iTrainee.save(tr);
		
	}

}
