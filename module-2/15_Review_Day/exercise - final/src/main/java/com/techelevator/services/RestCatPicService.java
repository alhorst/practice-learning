package com.techelevator.services;

import com.techelevator.model.CatCard;
import org.springframework.stereotype.Component;

import com.techelevator.model.CatPic;
import org.springframework.web.client.RestTemplate;

@Component
public class RestCatPicService implements CatPicService {

	private RestTemplate restTemplate = new RestTemplate();
	private final String API_URL = "https://cat-data.netlify.app/api/pictures/random";

	@Override
	public CatPic getPic() {
		CatPic picture = restTemplate.getForObject(API_URL, CatPic.class);
		return picture;
	}

}	
