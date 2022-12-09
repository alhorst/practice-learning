package com.techelevator.controller;

import com.techelevator.dao.CatCardDao;
import com.techelevator.model.CatCard;
import com.techelevator.model.CatFact;
import com.techelevator.model.CatPic;
import com.techelevator.services.CatFactService;
import com.techelevator.services.CatPicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/cards")
public class CatCardController {
    //attributes to:
    //one to the CatFactService interface
    @Autowired
    CatFactService catFactService;
    //one to the CatPicService interface
    @Autowired
    CatPicService catPicService;
    //one to the CatCardDao interface
    @Autowired
    CatCardDao dao;

    @RequestMapping(method = RequestMethod.GET)
    public List<CatCard> listAllCatCards() {
        return dao.getAllCatCards();
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public CatCard getCatCardById(@PathVariable int id) {
        CatCard catCard = dao.getCatCardById(id);
        if (catCard == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "CatCard not found.");
        } else {
            return dao.getCatCardById(id);
        }
    }

    @RequestMapping(path = "/random", method = RequestMethod.GET)
    public CatCard getRandomCard() {
        CatPic catPic = catPicService.getPic();
        CatFact catFact = catFactService.getFact();

        CatCard catCard = new CatCard();
        catCard.setImgUrl(catPic.getFile());
        catCard.setCatFact(catFact.getText());
        return catCard;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(method = RequestMethod.POST)
    public CatCard saveCatCard(@Valid @RequestBody CatCard catCard) {
        return dao.addCatCard(catCard);
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.PUT)
    public CatCard updateCatCard(@Valid @RequestBody CatCard catCard, @PathVariable int id) {
        CatCard updatedCatCard = dao.updateCatCard(catCard, id);
        if (updatedCatCard == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "CatCard not found in collection.");
        } else {
            return updatedCatCard;
        }
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable int id) {
        dao.deleteCatCard(id);
    }

}
