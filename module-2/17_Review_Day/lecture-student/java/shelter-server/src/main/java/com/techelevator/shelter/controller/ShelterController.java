package com.techelevator.shelter.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.techelevator.shelter.dao.PuppyDao;
import com.techelevator.shelter.dao.ShelterDao;

@RestController
public class ShelterController {

	@Autowired
	private ShelterDao shelterDao;
	@Autowired
	private PuppyDao puppyDao;
	

	
	

}
