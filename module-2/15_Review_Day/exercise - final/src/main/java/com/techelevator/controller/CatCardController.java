package com.techelevator.controller;

import com.techelevator.dao.CatCardDao;
import com.techelevator.model.CatCard;
import com.techelevator.model.CatFact;
import com.techelevator.model.CatPic;
import com.techelevator.services.CatFactService;
import com.techelevator.services.CatPicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/cards") // all mappings in this controller will start with '/api/cards'
public class CatCardController {
    // attributes to:
    // one to the CatFactService interface
    @Autowired
    CatFactService catFactService;
    // one to the CatPicService interface
    @Autowired
    CatPicService catPicService;
    // one to the CatCardDao interface
    @Autowired
    CatCardDao dao;


    @RequestMapping(method = RequestMethod.GET)
    public List<CatCard> listAllCatCards(){
        return dao.getAllCatCards();
    }

    @RequestMapping(path="/random", method = RequestMethod.GET)
    public CatCard createNewCatCard(){
        CatPic catPic = catPicService.getPic(); // return a catPic object
        CatFact catFact = catFactService.getFact();

        CatCard catCard = new CatCard();
        catCard.setImgUrl(catPic.getFile());  // get the String file name and set it
        catCard.setCatFact(catFact.getText()); // get the String text and set it
        return catCard;
    }

    @RequestMapping(method = RequestMethod.POST)
    public CatCard saveCatCard(@RequestBody CatCard catCard){
        return dao.addCatCard(catCard);
    }
}
