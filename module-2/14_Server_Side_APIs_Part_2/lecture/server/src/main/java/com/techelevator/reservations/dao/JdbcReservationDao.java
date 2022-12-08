package com.techelevator.reservations.dao;

import com.techelevator.reservations.model.Reservation;
import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

//@Component
public class JdbcReservationDao implements  ReservationDao{

    JdbcTemplate jdbcTemplate;
    public JdbcReservationDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate =  jdbcTemplate;
    }
    @Override
    public List<Reservation> findAll() {
        List<Reservation> reservationList = new ArrayList<>();
        String sql = "SELECT id, hotel_id, full_name, check_in_date, " +
                "check_out_date, guests FROM reservations";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        while (results.next()){
            Reservation reservation = mapRowToReservation(results);
            reservationList.add(reservation);
        }
        return reservationList;
    }

    @Override
    public List<Reservation> findByHotel(int hotelID) {
        List<Reservation> reservationList = new ArrayList<>();
        String sql = "SELECT id, hotel_id, full_name, check_in_date, " +
                "check_out_date, guests FROM reservation WHERE " +
                "hotel_id= ?";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, hotelID);
        while (results.next()){
            Reservation reservation = mapRowToReservation(results);
            reservationList.add(reservation);
        }
        return reservationList;
    }

    @Override
    public Reservation get(int reservationID) {
        Reservation reservation = null;
        String sql = "SELECT id, hotel_id, full_name, check_in_date, " +
                "check_out_date, guests FROM reservation WHERE " +
                "id= ?";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, reservationID);
        if (results.next()){
            reservation = mapRowToReservation(results);
        }
        return reservation;
    }

    @Override
    public Reservation create(Reservation reservation, int hotelID) {
        String sql = "INSERT INTO reservation (hotel_id, full_name, check_in_date, " +
                "check_out_date, guests) VALUES (?, ?, ?, ?, ?) " +
                "RETURNING id";
        Reservation newReservation = null;
        String checkInDate = reservation.getCheckinDate();
        DateTimeFormatter format = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        LocalDate dateLD = LocalDate.parse(checkInDate, format);
        LocalDate checkOutDate = LocalDate.parse(reservation.getCheckoutDate(),
                format);

        Integer id = jdbcTemplate.queryForObject(sql, Integer.class,
                hotelID, reservation.getFullName(), dateLD,
                checkOutDate, reservation.getGuests());
        newReservation = get(id);
        return newReservation;
    }

    @Override
    public Reservation update(Reservation reservation, int id) {
        return null;
    }

    @Override
    public void delete(int id) {

    }

    private Reservation mapRowToReservation(SqlRowSet row){
        Reservation reservation = new Reservation(row.getInt("id"),
                row.getInt("hotel_id"), row.getString("full_name"),
                row.getString("check_in_date"), row.getString("check_out_date"),
                row.getInt("guests"));
        return reservation;
    }
}
