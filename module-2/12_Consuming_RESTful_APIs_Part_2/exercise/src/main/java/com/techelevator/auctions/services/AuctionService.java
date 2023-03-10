package com.techelevator.auctions.services;

import com.techelevator.util.BasicLogger;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestClientResponseException;
import org.springframework.web.client.RestTemplate;

import com.techelevator.auctions.model.Auction;

public class AuctionService {

    public static String API_BASE_URL = "http://localhost:3000/auctions/";
    private RestTemplate restTemplate = new RestTemplate();


    public Auction add(Auction newAuction) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<Auction> entity = new HttpEntity<>(newAuction, headers);

        Auction returnedAuction = null;
        try {
            returnedAuction = restTemplate.postForObject(API_BASE_URL, entity, Auction.class);
        } catch (RestClientResponseException e) {
            BasicLogger.log("Error: " + e.getRawStatusCode() + ": " + e.getStatusText());
        } catch (ResourceAccessException e) {
            BasicLogger.log("Error: " + e.getMessage());
        }
        return returnedAuction;
    }

    public boolean update(Auction updatedAuction) {
        boolean success = false;
        try {
            restTemplate.put(API_BASE_URL + updatedAuction.getId(), makeEntity(updatedAuction));
            success = true;
        } catch (RestClientResponseException e) {
            BasicLogger.log("Error: " + e.getRawStatusCode() + ": " + e.getStatusText());
        } catch (ResourceAccessException e) {
            BasicLogger.log("Error: " + e.getMessage());
        }
        return success;
    }

    public boolean delete(int auctionId) {
        boolean success = false;
        try {
            restTemplate.delete(API_BASE_URL + auctionId);
            success = true;
        } catch (RestClientResponseException e) {
            BasicLogger.log("Error: " + e.getRawStatusCode() + ": " + e.getStatusText());
        } catch (ResourceAccessException e) {
            BasicLogger.log("Error: " + e.getMessage());
        }
        return success;
    }




    public Auction[] getAllAuctions() {
        Auction[] auctions = null;
        try {
            auctions = restTemplate.getForObject(API_BASE_URL, Auction[].class);
        } catch (RestClientResponseException e) {
            BasicLogger.log(e.getRawStatusCode() + " : " + e.getStatusText());
        } catch (ResourceAccessException e) {
            BasicLogger.log(e.getMessage());
        }
        return auctions;
    }

    public Auction getAuction(int id) {
        Auction auction = null;
        try {
            auction = restTemplate.getForObject(API_BASE_URL + id, Auction.class);
        } catch (RestClientResponseException e) {
            BasicLogger.log(e.getRawStatusCode() + " : " + e.getStatusText());
        } catch (ResourceAccessException e) {
            BasicLogger.log(e.getMessage());
        }
        return auction;
    }

    public Auction[] getAuctionsMatchingTitle(String title) {
        Auction[] auctions = null;
        try {
            auctions = restTemplate.getForObject(API_BASE_URL + "?title_like=" + title, Auction[].class);
        } catch (RestClientResponseException e) {
            BasicLogger.log(e.getRawStatusCode() + " : " + e.getStatusText());
        } catch (ResourceAccessException e) {
            BasicLogger.log(e.getMessage());
        }
        return auctions;
    }

    public Auction[] getAuctionsAtOrBelowPrice(double price) {
        Auction[] auctions = null;
        try {
            auctions = restTemplate.getForObject(API_BASE_URL + "?currentBid_lte=" + price, Auction[].class);
        } catch (RestClientResponseException e) {
            BasicLogger.log(e.getRawStatusCode() + " : " + e.getStatusText());
        } catch (ResourceAccessException e) {
            BasicLogger.log(e.getMessage());
        }
        return auctions;
    }

    private HttpEntity<Auction> makeEntity(Auction newAuction) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON); // what will be sent will be in JSON format
        HttpEntity<Auction> entity = new HttpEntity<>(newAuction, headers);
        return entity;
    }

}
