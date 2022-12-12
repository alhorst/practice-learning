package com.techelevator.shelter.dao;

import java.util.List;

import com.techelevator.shelter.model.Shelter;

public interface ShelterDao {
	
	List<Shelter> list();
	
	void create(Shelter shelter);
	
	Shelter get(int id);

}
