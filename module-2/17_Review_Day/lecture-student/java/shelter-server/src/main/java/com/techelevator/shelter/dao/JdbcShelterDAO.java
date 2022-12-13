package com.techelevator.shelter.dao;

import com.techelevator.shelter.model.Shelter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientResponseException;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcShelterDAO implements ShelterDAO {

    private final JdbcTemplate jdbcTemplate;

    public JdbcShelterDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Shelter getShelter(int shelterId) {
        Shelter shelter = null;
        String sql = "SELECT shelter_id, shelter_name, shelter_address, shelter_city, " +
                "shelter_state, shelter_zip FROM shelter WHERE shelter_id = ?";
        SqlRowSet results =  jdbcTemplate.queryForRowSet(sql, shelterId);
        if (results.next()) {
            shelter = mapRowToShelter(results);
        }
        return shelter;
    }

    @Override
    public List<Shelter> getAllShelters() {
        List<Shelter> shelterList = new ArrayList<>();
        String sql = "SELECT shelter_id, shelter_name, shelter_address, shelter_city," +
                "shelter_state, shelter_zip FROM shelter";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        while (results.next()) {
            shelterList.add(mapRowToShelter(results));
        }
        return shelterList;
    }


    @Override
    public Shelter createShelter(Shelter shelter) {
        Shelter newShelter = null;
        String sql = "INSERT INTO shelter (shelter_name, shelter_address, shelter_city, shelter_state, " +
                "shelter_zip) VALUES (?, ?, ?, ?, ?) RETURNING shelter_id";
        Integer shelterId = jdbcTemplate.queryForObject(sql, Integer.class, shelter.getName(),
                shelter.getAddress(), shelter.getCity(), shelter.getState(), shelter.getZip());
        newShelter = getShelter(shelterId);
        return newShelter;
    }

    @Override
    public boolean updateShelter(Shelter shelter) {
        String sql = "UPDATE shelter SET shelter_name = ?, shelter_address = ?, shelter_city = ?, " +
                "shelter_state = ?, shelter_zip = ?, WHERE shelter_id = ?";
        boolean success = false;
            int linesReturned = jdbcTemplate.update(sql, shelter.getName(), shelter.getAddress(), shelter.getCity(),
                    shelter.getState(), shelter.getZip(), shelter.getShelterId());
            if (linesReturned == 1) {
                success = true;
            } else {
                System.out.println("Shelter update failed.");
            }
        return success;
    }

    @Override
    public boolean deleteShelter(int shelterId) {
        String sql = "DELETE FROM shelter WHERE shelter_id = ?";
        boolean success = false;
        int numberOfRowsDeleted = jdbcTemplate.update(sql, shelterId);
        if (numberOfRowsDeleted == 1) {
            success = true;
        } else {
            System.out.println("Shelter delete failed.");
        }
        return success;
    }

    private Shelter mapRowToShelter(SqlRowSet results) {
        Shelter shelter = new Shelter();
        shelter.setShelterId(results.getInt("shelter_id"));
        shelter.setName(results.getString("shelter_name"));
        shelter.setAddress(results.getString("shelter_address"));
        shelter.setCity(results.getString("shelter_city"));
        shelter.setState(results.getString("shelter_state"));
        shelter.setZip(results.getString("shelter_zip"));
        return shelter;
    }
}
