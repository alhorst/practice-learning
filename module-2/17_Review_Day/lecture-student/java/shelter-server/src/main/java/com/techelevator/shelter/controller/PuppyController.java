package com.techelevator.shelter.controller;

import com.techelevator.shelter.dao.PuppyDAO;
import com.techelevator.shelter.model.Puppy;
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
public class PuppyController {

    @Autowired
    private PuppyDAO puppyDAO;

    @PreAuthorize("permitAll")
    @RequestMapping(path = "/puppies", method = RequestMethod.GET)
    public List<Puppy> listAllPuppies() {
        return puppyDAO.getAllPuppies();
    }

    @GetMapping(path = "/puppies/{id}")
    public Puppy getPuppy(@PathVariable int id) {
        Puppy puppy = puppyDAO.getPuppy(id);
        if (puppy == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Puppy not found.");
        } else {
            return puppy;
        }
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/puppies")
    public Puppy addPuppy(@Valid @RequestBody Puppy puppy) {
        return puppyDAO.addPuppy(puppy);
    }

    //@PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/puppies/{id}")
    public void updatePuppy(@Valid @RequestBody Puppy puppy, @PathVariable int id) {
        puppy.setPuppyId(id);
        boolean updated = puppyDAO.updatePuppy(puppy);
        if (!updated) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Puppy not updated.");
        }
    }

    //@PreAuthorize("hasRole('ADMIN')")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/puppies/{id}")
    public void deleteShelter(@PathVariable int id, Principal principal) {
        puppyDAO.adoptPuppy(id);
        auditLog("delete", id, principal.getName());
    }

    public void auditLog(String operation, int puppy, String username) {
        System.out.println(
                "User: " + username + "performed the operation: " + operation + "on puppy: " + puppy);
    }
}
