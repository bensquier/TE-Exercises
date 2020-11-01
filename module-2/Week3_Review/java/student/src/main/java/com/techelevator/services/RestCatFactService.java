package com.techelevator.services;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.techelevator.model.CatCard;
import com.techelevator.model.CatFact;

@Component
public class RestCatFactService implements CatFactService {
	
	private RestTemplate restTemplate = new RestTemplate();
	private final String CATFACT_URL = "https://cat-fact.herokuapp.com/facts/random";
	
	
	
	@Override
	public CatFact getFact() {
		CatFact catFact = null;
		catFact = restTemplate.getForObject(CATFACT_URL, CatFact.class);
		return catFact;
	}

}
