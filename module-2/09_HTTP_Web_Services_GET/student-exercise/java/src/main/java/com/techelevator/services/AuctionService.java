package com.techelevator.services;

import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestClientResponseException;
import org.springframework.web.client.RestTemplate;

import com.techelevator.models.Auction;

public class AuctionService {

    private final String BASE_URL;
    public RestTemplate restTemplate = new RestTemplate();
    private final ConsoleService console = new ConsoleService();

    public AuctionService(String url) {
        BASE_URL = url;
    }


    public Auction[] getAll() {
        
        //api code here
        return null;
    
    }

    public Auction getOne(int id) {

        //api code here
        return null;

    }

    public Auction[] getByTitle(String title) {

        //api code here
        return null;
        
    }

    public Auction[] getByPrice(double price) {

        //api code here
        return null;

    }

}
