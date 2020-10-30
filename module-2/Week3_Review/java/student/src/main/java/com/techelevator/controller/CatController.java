package com.techelevator.controller;

import com.techelevator.model.CatCard;
import com.techelevator.model.CatCardDAO;
import com.techelevator.model.CatCardNotFoundException;
import com.techelevator.model.CatFact;
import com.techelevator.model.CatPic;
import com.techelevator.services.CatFactService;
import com.techelevator.services.CatPicService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@RestController
public class CatController {

    private CatCardDAO catCardDao;
    private CatFactService catFactService;
    private CatPicService catPicService;

    public CatController(CatCardDAO catCardDao, CatFactService catFactService, CatPicService catPicService) {
        this.catCardDao = catCardDao;
        this.catFactService = catFactService;
        this.catPicService = catPicService;
    }
    
   @RequestMapping(path = "/api/cards", method = RequestMethod.GET)
   public List<CatCard> list(){
	   return catCardDao.list();
   }
   
   @RequestMapping(path = "/api/cards/{id}", method = RequestMethod.GET)
   public CatCard get(@PathVariable int id) {
	   return catCardDao.get(id);
   }
   
   @RequestMapping(path = "/api/cards/random", method = RequestMethod.GET)
   public CatCard random() {
	   
	   return catCards.get(new Random().nextInt(catCards.size()));
   }
   
   @ResponseStatus(HttpStatus.CREATED)
   @RequestMapping(path = "api/cards", method = RequestMethod.POST)
   public boolean save(@Valid @RequestBody CatCard catCard) {
	   return catCardDao.save(catCard);
   }
   
   @RequestMapping(path = "/api/cards/{id}", method = RequestMethod.PUT)
   public boolean update(@Valid @RequestBody CatCard catCard, @PathVariable int id) throws CatCardNotFoundException {
	   return catCardDao.update(id, catCard);
   }
   
   @ResponseStatus(HttpStatus.NO_CONTENT)
   @RequestMapping(path = "/api/cards/{id}", method = RequestMethod.DELETE)
   public boolean delete(@PathVariable int id) throws CatCardNotFoundException {
	   return catCardDao.delete(id);
   }
   


}
