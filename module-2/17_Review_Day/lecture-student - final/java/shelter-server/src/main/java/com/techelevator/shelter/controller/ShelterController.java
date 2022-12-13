package com.techelevator.shelter.controller;

import com.techelevator.shelter.dao.ShelterDAO;
import com.techelevator.shelter.model.Shelter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.List;

@RestController
@PreAuthorize("isAuthenticated()") // must be logged in and provide a token in order to access any of the API endpoints
public class ShelterController {

    // attributes or properties
    @Autowired // let Spring inject the class (jdbcShelterdao) for us - must have @component at the top of
    // jdbc class
    private ShelterDAO shelterDao; // interface

    // because of the @Autowired annotation, no need for a constructor!!


    @PreAuthorize("permitAll") // no token needed to get all the shelters!
    @RequestMapping(path = "/shelters", method = RequestMethod.GET)
    // that in Postman, GET request to the path of http://localhost:8080/shelters
    public List<Shelter> getAllShelters() {
        return shelterDao.getAllShelters();
    }

    @GetMapping("/shelter/{id}")
    public Shelter getShelterById(@PathVariable int id){
        Shelter shelter = shelterDao.getShelter(id);
        if (shelter == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Shelter not found!!!");
        } else {
            return shelter;
        }
    }

    @PostMapping("/shelter")
    @ResponseStatus(HttpStatus.CREATED)
    public Shelter addAShelter(@Valid @RequestBody Shelter shelter){
        return shelterDao.createShelter(shelter);
    }

    @PutMapping("/shelter/{id}")
    public void updateShelter(@PathVariable int id, @RequestBody Shelter shelter){
        shelter.setShelterId(id);
        boolean updated = shelterDao.updateShelter(shelter);
        if (!updated) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Shelter not updated!");
        }

    }


}
