package com.techelevator.reservations.controllers;

import com.techelevator.reservations.dao.HotelDao;
import com.techelevator.reservations.dao.MemoryHotelDao;
import com.techelevator.reservations.dao.MemoryReservationDao;
import com.techelevator.reservations.dao.ReservationDao;
import com.techelevator.reservations.model.Hotel;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@RestController
public class HotelController {

    private HotelDao hotelDao;
    private ReservationDao reservationDao;

    public HotelController() {
        this.hotelDao = new MemoryHotelDao();
        this.reservationDao = new MemoryReservationDao(hotelDao);
    }

    /**
     * Return All Hotels
     *
     * @return a list of all hotels in the system
     */
    @RequestMapping(path = "/hotels", method = RequestMethod.GET)
    public List<Hotel> list() {
        return hotelDao.list();
    }

    /**
     * Return hotel information
     *
     * @param id the id of the hotel
     * @return all info for a given hotel
     */
    @RequestMapping(path = "/hotels/{id}", method = RequestMethod.GET)
    public Hotel get(@PathVariable int id) {
        return hotelDao.get(id);
    }

    // http://localhost:8080/hotels/filter?state=ohio&city=cleveland
    @RequestMapping(path="/hotels/filter", method = RequestMethod.GET)
    public List<Hotel> getHotelsFilterByStateAndCity(@RequestParam String state,
                                                     @RequestParam(required = false)String city){
        List<Hotel> allHotels = list(); // all the hotels
        List<Hotel> filteredHotels = new ArrayList<>();

        //loop through allHotels and add the filtered ones to filteredHotels
        for (Hotel hotel : allHotels){
            // if city was passed in
            if (city != null){
                if (hotel.getAddress().getCity().toLowerCase().equals(city.toLowerCase())){
                    filteredHotels.add(hotel);
                }
            } else {
                if(hotel.getAddress().getState().equalsIgnoreCase(state)) {
                   filteredHotels.add(hotel);
                }
            }
        }
        return filteredHotels;
    }


}
