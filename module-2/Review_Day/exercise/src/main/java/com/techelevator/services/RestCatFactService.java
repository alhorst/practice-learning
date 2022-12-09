package com.techelevator.services;

import com.techelevator.model.CatFact;
import org.springframework.stereotype.Component;

import com.techelevator.model.CatCard;
import org.springframework.web.client.RestTemplate;

@Component
public class RestCatFactService implements CatFactService {

	private RestTemplate restTemplate = new RestTemplate();

	public final String API_URL = "https://cat-data.netlify.app/api/facts/random";

	@Override
	public CatFact getFact() {
		return restTemplate.getForObject(API_URL, CatFact.class);

	}

}
