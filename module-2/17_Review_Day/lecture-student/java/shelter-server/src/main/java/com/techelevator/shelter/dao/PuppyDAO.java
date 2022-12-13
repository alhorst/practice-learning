package com.techelevator.shelter.dao;

import com.techelevator.shelter.model.Puppy;

import java.util.List;

public interface PuppyDAO {

    Puppy getPuppy(int puppyId);

    List<Puppy> getAllPuppies();

    Puppy addPuppy(Puppy puppy);

    boolean updatePuppy(Puppy puppy);

    boolean adoptPuppy(int puppyId);
}
