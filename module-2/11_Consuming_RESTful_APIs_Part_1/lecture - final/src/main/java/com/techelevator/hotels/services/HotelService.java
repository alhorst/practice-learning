package com.techelevator.hotels.services;

import com.techelevator.hotels.model.City;
import com.techelevator.hotels.model.Hotel;
import com.techelevator.hotels.model.Review;
import org.springframework.web.client.RestTemplate;

public class HotelService {

    private static final String API_BASE_URL = "http://localhost:3000/";
    private final RestTemplate restTemplate = new RestTemplate(); // From Spring

    public Hotel[] listHotels() {
        // Hotel[] hotelArray - variable to hold our array of hotel objects
        // restTemplate - our RestTemplate object from Spring that lets us query an API
        // getForObject - method we are calling that will query and get an Object
        // 1 param is the url to "get the hotel objects"
        // 2 param is the class literal , Hotel[].class -- that the methods needs
        Hotel [] hotelArray = restTemplate.getForObject(API_BASE_URL + "hotels", Hotel[].class);
        return hotelArray;
    }

    public Review[] listReviews() {
        return (restTemplate.getForObject(API_BASE_URL + "reviews", Review[].class));
//        return reviewArray;
    }

    public Hotel getHotelById(int id) {

        return (restTemplate.getForObject(API_BASE_URL + "hotels/" + id, Hotel.class));
    }

    public Review[] getReviewsByHotelId(int hotelID) {
        return restTemplate.getForObject(API_BASE_URL + "hotels/" + hotelID + "/reviews",
                Review[].class);
//        return restTemplate.getForObject(API_BASE_URL + "reviews?hotel_id=" + hotelID,
//                Review[].class);
    }

    public Hotel[] getHotelsByStarRating(int stars) {
        return restTemplate.getForObject(API_BASE_URL + "hotels?stars=" + stars, Hotel[].class);
    }

    public City getWithCustomQuery(){
        return restTemplate.getForObject("https://api.teleport.org/api/cities/geonameid:5128581/",
                City.class);
    }

}
