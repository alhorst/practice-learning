package com.techelevator.reservations.dao;

import com.techelevator.reservations.model.Hotel;

import java.util.List;

public interface HotelDao {

    List<Hotel> list(); //read

    void create(Hotel hotel); //create

    Hotel get(int id); //read

}
