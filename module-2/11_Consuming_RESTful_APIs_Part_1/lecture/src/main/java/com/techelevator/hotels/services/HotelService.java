package com.techelevator.hotels.services;

import com.techelevator.hotels.model.City;
import com.techelevator.hotels.model.Hotel;
import com.techelevator.hotels.model.Review;
import org.springframework.web.client.RestTemplate;

public class HotelService {

    private static final String API_BASE_URL = "http://localhost:3000/";
    private final RestTemplate restTemplate = new RestTemplate();
        //restTemplate is our RestTemplate object from Spring that lets us query an API
        //getForObject is the method we're calling that queries and gets an Object
        //param 1 is the url to get the objects
        //param 2 is the
    public Hotel[] listHotels() {
        Hotel[] hotelArray = restTemplate.getForObject(API_BASE_URL + "hotels", Hotel[].class);
        return hotelArray;
    }

    public Review[] listReviews() {
        Review[] reviewArray = restTemplate.getForObject(API_BASE_URL + "reviews", Review[].class);
        return reviewArray;
    }

    public Hotel getHotelById(int id) {
        return (restTemplate.getForObject(API_BASE_URL + "hotels/" + id, Hotel.class));
    }

    public Review[] getReviewsByHotelId(int hotelID) {
        return (restTemplate.getForObject(API_BASE_URL + "hotels/" + hotelID + "/reviews", Review[].class));
    }

    public Hotel[] getHotelsByStarRating(int stars) {  //"reviews?stars=" + stars
        return (restTemplate.getForObject(API_BASE_URL + "hotels/" + stars, Hotel[].class));
    }

    public City getWithCustomQuery() {
        return (restTemplate.getForObject("https://api.teleport.org/api/cities/geonameid:5128581/", City.class));
    }

}
