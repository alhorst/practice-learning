package com.techelevator.services;

import org.springframework.stereotype.Component;

import com.techelevator.model.CatFact;
import org.springframework.web.client.RestTemplate;

@Component
public class RestCatFactService implements CatFactService {

	private RestTemplate restTemplate = new RestTemplate();
	private final String API_URL = "https://cat-data.netlify.app/api/facts/random";

	@Override
	public CatFact getFact() {
		CatFact catFact = restTemplate.getForObject(API_URL, CatFact.class);
		return catFact;
	}

}
