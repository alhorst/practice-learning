package com.techelevator.shelter.dao;

import com.techelevator.shelter.model.Puppy;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcPuppyDAO implements PuppyDAO{

    private final JdbcTemplate jdbcTemplate;

    public JdbcPuppyDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Puppy getPuppy(int puppyId) {
        Puppy puppy = null;
        String sql = "SELECT puppy_id, puppy_name, puppy_breed, puppy_age, puppy_gender, " +
                "shelter_id FROM puppy WHERE puppy_id = ?";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, puppyId);
        if (results.next()) {
            puppy = mapRowToPuppy(results);
        }
        return puppy;
    }

    @Override
    public List<Puppy> getAllPuppies() {
        List<Puppy> puppyList = new ArrayList<>();
        String sql = "SELECT puppy_id, puppy_name, puppy_breed, puppy_age, puppy_gender, " +
                  "shelter_id FROM puppy";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        while (results.next()) {
            puppyList.add(mapRowToPuppy(results));
        }
        return puppyList;
    }

    @Override
    public Puppy addPuppy(Puppy puppy) {
        Puppy newPuppy = null;
        String sql = "INSERT INTO puppy (puppy_name, puppy_breed, puppy_age, " +
                "puppy_gender, shelter_id) VALUES (?, ?, ?, ?, ?) RETURNING puppy_id";
        Integer puppyId = jdbcTemplate.queryForObject(sql, Integer.class, puppy.getPuppyName(),
                puppy.getPuppyBreed(), puppy.getPuppyAge(), puppy.getPuppyGender(), puppy.getShelterId());
        newPuppy = getPuppy(puppyId);
        return newPuppy;
    }

    @Override
    public boolean updatePuppy(Puppy puppy) {
        String sql = "UPDATE puppy SET puppy_name = ?, puppy_breed = ?, puppy_age = ?, " +
                "puppy_gender = ?, shelter_id = ?, WHERE puppy_id = ?";
        boolean success = false;
        int linesReturned = jdbcTemplate.update(sql, puppy.getPuppyName(), puppy.getPuppyBreed(), puppy.getPuppyAge(),
                puppy.getPuppyGender(), puppy.getShelterId(), puppy.getPuppyId());
        if (linesReturned == 1) {
            success = true;
        } else {
            System.out.println("Puppy update failed.");
        }
        return success;
    }

    @Override
    public boolean adoptPuppy(int puppyId) {
        String sql = "DELETE FROM puppy WHERE puppy_id = ?";
        boolean success = false;
        int numberOfRowsDeleted = jdbcTemplate.update(sql, puppyId);
        if (numberOfRowsDeleted == 1) {
            success = true;
        } else {
            System.out.println("Deleting adopted puppy from database failed.");
        }
        return success;
    }

    private Puppy mapRowToPuppy(SqlRowSet results) {
        Puppy puppy = new Puppy();
        puppy.setShelterId(results.getInt("puppy_id"));
        puppy.setPuppyName(results.getString("puppy_name"));
        puppy.setPuppyAge(results.getInt("puppy_age"));
        puppy.setPuppyBreed(results.getString("puppy_breed"));
        puppy.setPuppyGender(results.getString("puppy_gender"));
        puppy.setShelterId(results.getInt("shelter_id"));
        return puppy;
    }
}
