package com.techelevator.reservations.dao;

import java.util.List;
import com.techelevator.reservations.model.Reservation;

public interface ReservationDao {

    List<Reservation> findAll();  // Read

    List<Reservation> findByHotel(int hotelID);  // Read

    Reservation get(int reservationID);  // Read

    Reservation create(Reservation reservation, int hotelID);  // Create

}
