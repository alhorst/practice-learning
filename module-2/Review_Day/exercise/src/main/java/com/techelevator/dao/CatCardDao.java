package com.techelevator.dao;

import com.techelevator.model.CatCard;

import java.util.List;

public interface CatCardDao {
    //READ
    List<CatCard> getAllCatCards();

    CatCard getCatCardById(int id);
    //CREATE
    CatCard addCatCard(CatCard catCard);
    //UPDATE
    CatCard updateCatCard(CatCard catCard, int id);
    //DELETE
    void deleteCatCard(int id);
}
