package com.techelevator.shelter.dao.jdbc;

import java.util.List;

import org.springframework.stereotype.Component;

import com.techelevator.shelter.dao.PuppyDao;
import com.techelevator.shelter.model.Puppy;

@Component
public class JdbcPuppyDao implements PuppyDao {

	@Override
	public List<Puppy> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Puppy> findByShelter(int shelterId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Puppy get(int puppyId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Puppy addPuppy(Puppy puppy, int shelterId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Puppy updatePuppy(Puppy puppy, int puppyId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void adopt(int puppyId) {
		// TODO Auto-generated method stub

	}

}
