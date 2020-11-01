package com.techelevator.model;

import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

public class RandomCatCardDTO {
	
	@NotEmpty
	private String fact;
	@NotEmpty
	private String imgUrl;
	@JsonInclude(Include.NON_NULL)
	private String caption;
	
	
	public RandomCatCardDTO(CatFact catFact, CatPic imgUrl) {
		this.fact = catFact.getText();
		this.imgUrl = imgUrl.getFile();
	}
//	
//	public RandomCatCardDTO(CatFact catFact, CatPic imgUrl, String caption) {
//		this(catFact,imgUrl);
//		this.caption = caption;
//	}
	
	public RandomCatCardDTO() {}
	
	public String getFact() {
		return fact;
	}
	public void setFact(String catFact) {
		this.fact = catFact;
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
