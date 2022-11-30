package com.techelevator;

import com.techelevator.model.City;
import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import java.util.ArrayList;
import java.util.List;

public class DAOExample {

    public static void main(String[] args) {

        // create a datasource -- a connection to the database
        BasicDataSource unitedStatesDataSource = new BasicDataSource();

        // say using the jdbc:postgresql driver
        unitedStatesDataSource.setUrl("jdbc:postgresql://localhost:5432/UnitedStates");
        // set a username
        unitedStatesDataSource.setUsername("postgres");
        // set a password
        unitedStatesDataSource.setPassword("postgres1");

        // pass that basicdatasource object into the jdbctemplate object
        JdbcTemplate jdbcTemplate = new JdbcTemplate(unitedStatesDataSource);

        // Return a list of all cities in the state of OH

        String state_name = "OH";
        String sql = "SELECT * FROM city WHERE state_abbreviation = ?";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, state_name);
        // SqlRowSet -- is a set (a data structure) holding all the rows from the query to the db

        System.out.println("All the cities in Ohio: ");

        // create a data structure -- List
        List<City> cityList = new ArrayList<>(); // an empty structure
        while (results.next()){ ///  PSA -- you Must ALWAYS use .next() at least once to get the data!
            // inside the loop, the var results will hold one row (or record) of data!
            int id = results.getInt("city_id");
            // "city_name must match a column name in the database
            String name = results.getString("city_name");
            String state = results.getString("state_abbreviation");
            int population = results.getInt("population");
            double area = results.getDouble("area");
            System.out.println(name + ", " + state);
            City city = new City();// an empty city object
            city.setCityId(id);
            city.setCityName(name);
            city.setStateAbbreviation(state);
            city.setPopulation(population);
            city.setArea(area);
            cityList.add(city);
        }
    }
}
