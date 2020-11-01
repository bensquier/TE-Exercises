package com.techelevator.model;

import javax.validation.constraints.NotEmpty;

import org.springframework.data.annotation.Id;

public class CatCard {
	@Id
	public Long id;
	@NotEmpty
	public String fact;
	@NotEmpty
	public String imgUrl;
	@NotEmpty
	public String caption;
	
	public CatCard() {};
	
	public CatCard(RandomCatCardDTO randomCatCard) {
		this.fact = randomCatCard.getFact();
		this.imgUrl = randomCatCard.getImgUrl();
		this.caption = randomCatCard.getCaption();
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getFact() {
		return fact;
	}
	public void setFact(String fact) {
		this.fact = fact;
	}
	
	public String getImgUrl() {
		return imgUrl;
	}
	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}
	
	public String getCaption() {
		return caption;
	}
	public void setCaption(String caption) {
		this.caption = caption;
	}
	
}
