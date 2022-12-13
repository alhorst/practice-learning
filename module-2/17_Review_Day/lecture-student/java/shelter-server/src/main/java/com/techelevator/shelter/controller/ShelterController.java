package com.techelevator.shelter.controller;

import com.techelevator.shelter.dao.ShelterDAO;
import com.techelevator.shelter.model.Shelter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.security.Principal;
import java.util.List;

@RestController
@PreAuthorize("isAuthenticated()")
public class ShelterController {

    @Autowired
    private ShelterDAO shelterDAO;

    @PreAuthorize("permitAll")
    @RequestMapping(path = "/shelters", method = RequestMethod.GET)
    public List<Shelter> listAllShelters() {
        return shelterDAO.getAllShelters();
    }

    @GetMapping(path = "/shelters/{id}")
    public Shelter getShelterById(@PathVariable int id) {
        Shelter shelter = shelterDAO.getShelter(id);
        if (shelter == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Shelter not found.");
        } else {
            return shelter;
        }
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/shelters")
    public Shelter addShelter(@Valid @RequestBody Shelter shelter) {
        return shelterDAO.createShelter(shelter);
    }

    //@PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/shelters/{id}")
    public void updateShelter(@Valid @RequestBody Shelter shelter, @PathVariable int id) {
        shelter.setShelterId(id);
        boolean updated = shelterDAO.updateShelter(shelter);
        if (!updated) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Shelter not updated.");
        }
    }

    //@PreAuthorize("hasRole('ADMIN')")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/shelters/{id}")
    public void deleteShelter(@PathVariable int id, Principal principal) {
        shelterDAO.deleteShelter(id);
        auditLog("delete", id, principal.getName());
    }

    public void auditLog(String operation, int shelter, String username) {
        System.out.println(
                "User: " + username + "performed the operation: " + operation + "on shelter: " + shelter);
    }
}
