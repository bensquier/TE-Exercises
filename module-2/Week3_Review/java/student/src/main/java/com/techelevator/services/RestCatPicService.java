package com.techelevator.services;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.techelevator.model.CatPic;

@Component
public class RestCatPicService implements CatPicService {

	private RestTemplate restTemplate = new RestTemplate();
	private final String CATPIC_URL = "https://random-cat-image.herokuapp.com/";
	
	@Override
	public CatPic getPic() {
		CatPic catPic = null;
		catPic = restTemplate.getForObject(CATPIC_URL, CatPic.class); 
		return catPic;
	}

}	
