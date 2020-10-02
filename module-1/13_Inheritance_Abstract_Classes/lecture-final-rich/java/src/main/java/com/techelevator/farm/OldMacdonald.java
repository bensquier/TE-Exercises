package com.techelevator.farm;

public class OldMacdonald {
	public static void main(String[] args) {

		Cow myCow = new Cow();
		Chicken myChicken = new Chicken();
		Pig myPig = new Pig();
		Cat myCat = new Cat();
		
		// THERE'S A 30% CHASE THAT THE CAT IS ASLEEP
		int catRoll = (int)((Math.random() * 9) + 1 );
		myCat.sleep( catRoll > 7 );
		
		
		Singable[] singables =
				new Singable[] {myCow, myChicken, myPig, new Tractor(), myCat, new Tiger()};

		for (Singable singable : singables) {
			String name = singable.getName();
			String sound = singable.getSound();
			System.out.println("Old MacDonald had a farm, ee, ay, ee, ay, oh!");
			System.out.println("And on his farm he had a " + name
					+ ", ee, ay, ee, ay, oh!");
			System.out.println("With a " + sound + " " + sound + " here");
			System.out.println("And a " + sound + " " + sound + " there");
			System.out.println("Here a " + sound + " there a " + sound
					+ " everywhere a " + sound + " " + sound);
			System.out.println();
		}

		Sellable[] sellables = new Sellable[] {new Cow(), new Pig(), new Egg()};

		for (Sellable sellable : sellables) {
			System.out.println("Step right up and get your " + sellable.getName());
			System.out.println("Only $" + sellable.getPrice());
		}
	}
}