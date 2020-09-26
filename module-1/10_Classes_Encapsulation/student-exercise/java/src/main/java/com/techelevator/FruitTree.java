package com.techelevator;

public class FruitTree {
	
	private String typeOfFruit;
	private int piecesOfFruitLeft;
	
	public FruitTree(String typeOfFruit, int startingPiecesOfFruit) {
		this.typeOfFruit = typeOfFruit;
		this.piecesOfFruitLeft = startingPiecesOfFruit;
		
	}
	public String getTypeOfFruit() {
		return this.typeOfFruit;
	}
	public int getPiecesOfFruitLeft() {
		return this.piecesOfFruitLeft;
	}
	public boolean pickFruit(int numberOfPiecesToRemove) {
		if(piecesOfFruitLeft >= numberOfPiecesToRemove) {
			this.piecesOfFruitLeft -= numberOfPiecesToRemove;
			return true;
		}
		return false;
	}

}
