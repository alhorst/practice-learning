package com.techelevator.shelter.dao;

import com.techelevator.shelter.model.Shelter;

import java.util.List;

public interface ShelterDAO {
    //CRUD!!!

    Shelter getShelter(int shelterId);

    List<Shelter>  getAllShelters();

    Shelter createShelter(Shelter shelter);

    boolean updateShelter(Shelter shelter);

    boolean deleteShelter(int shelterId);
}
