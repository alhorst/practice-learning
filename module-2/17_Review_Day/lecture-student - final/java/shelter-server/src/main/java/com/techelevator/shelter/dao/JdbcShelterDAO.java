package com.techelevator.shelter.dao;

import com.techelevator.shelter.model.Shelter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientResponseException;

import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcShelterDAO implements ShelterDAO {

    JdbcTemplate jdbcTemplate;

    public JdbcShelterDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Shelter getShelter(int shelterId) {
        Shelter shelter = null;
        String sql = "SELECT * FROM shelter WHERE shelter_id = ?";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, shelterId);
        if (results.next()) { // we should only get back one shelter object
            shelter = mapRowToShelter(results);
        }
        return shelter;
    }

    @Override
    public List<Shelter> getAllShelters() {
        List<Shelter> shelters = new ArrayList<>();
        String sql = "SELECT * FROM shelter";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        while (results.next()) {
            Shelter shelter = mapRowToShelter(results);
            shelters.add(shelter);
        }
        return shelters;
    }

    @Override
    public Shelter createShelter(Shelter shelter) {
        Shelter newShelter = null;
        String sql = "INSERT INTO shelter (shelter_name, shelter_address, shelter_city, shelter_state, shelter_zip) " +
                "VALUES (?, ?, ?, ?, ?) RETURNING shelter_id"; // get back id in queryForObject can return the new object
        Integer shelterId = jdbcTemplate.queryForObject(sql, Integer.class, shelter.getName(), shelter.getAddress(),
                shelter.getCity(), shelter.getState(), shelter.getZip());

        //verify that the shelter was added by calling the getShelter
        newShelter = getShelter(shelterId);
        return newShelter;
    }

    @Override
    public boolean updateShelter(Shelter shelter) {
        String sql = "UPDATE shelter SET shelter_name = ?, shelter_city = ?, shelter_address = ?, shelter_state = ?, " +
                "shelter_zip = ? WHERE shelter_id = ? ";
        boolean success = false;
        int linesReturned = jdbcTemplate.update(sql, shelter.getName(), shelter.getCity(), shelter.getAddress(), shelter.getState(),
                shelter.getZip(), shelter.getShelterId());
        if (linesReturned == 1) {
            success = true;
        }

        return success;
    }

    @Override
    public boolean deleteShelter(int shelterId) {
        String sql = "DELETE from shelter WHERE shelter_id = ?";
        boolean success = false;

        int linesAffected = jdbcTemplate.update(sql, shelterId);
        if (linesAffected == 1) {
            success = true;
        }
        return success;
    }

    private Shelter mapRowToShelter(SqlRowSet results) {
        int id = results.getInt("shelter_id");
        String name = results.getString("shelter_name");
        String address = results.getString("shelter_address");
        String city = results.getString("shelter_city");
        String state = results.getString("shelter_state");
        String zip = results.getString("shelter_zip");
        return new Shelter(id, name, address, city, state, zip);
    }


}
