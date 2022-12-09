package com.techelevator.dao;

import com.techelevator.model.CatCard;

import java.util.List;

public interface CatCardDao {
    // interface methods are implicitly abstract and public
    // to connect to the database!
    // CRUD!!!
    // abstract methods

    // read
    List<CatCard> getAllCatCards();

    //CREATE
    CatCard addCatCard(CatCard catCard); // once you add, return the new cat card object

    // READ
    CatCard getCatCardById(int id);  // needed for the create method

    // UPDATE
    CatCard updateCatCard(CatCard catCard);


    // DELETE
    boolean deleteCatCard(int id);


}
