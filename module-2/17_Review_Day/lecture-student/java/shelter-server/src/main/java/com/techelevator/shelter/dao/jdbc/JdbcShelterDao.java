package com.techelevator.shelter.dao.jdbc;

import java.util.List;

import org.springframework.stereotype.Component;

import com.techelevator.shelter.dao.ShelterDao;
import com.techelevator.shelter.model.Shelter;

@Component
public class JdbcShelterDao implements ShelterDao {
	

	@Override
	public List<Shelter> list() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void create(Shelter shelter) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Shelter get(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
