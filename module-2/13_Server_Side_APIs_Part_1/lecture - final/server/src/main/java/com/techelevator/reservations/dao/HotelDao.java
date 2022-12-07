package com.techelevator.reservations.dao;

import com.techelevator.reservations.model.Hotel;

import java.util.List;

public interface HotelDao {

    List<Hotel> list();  //Read

    void create(Hotel hotel); // Create

    Hotel get(int id);  //Read

}
