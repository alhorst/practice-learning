package com.techelevator.shelter.dao;

import java.util.List;

import com.techelevator.shelter.model.Puppy;

public interface PuppyDao {

	List<Puppy> findAll();
	
	List<Puppy> findByShelter(int shelterId);
	
	Puppy get(int puppyId);
	
	Puppy addPuppy(Puppy puppy, int shelterId);
	
	Puppy updatePuppy(Puppy puppy, int puppyId);
	
	void adopt(int puppyId);
	
}
