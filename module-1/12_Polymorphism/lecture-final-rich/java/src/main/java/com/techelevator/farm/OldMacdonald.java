package com.techelevator.farm;

public class OldMacdonald {
	public static void main(String[] args) {
		
		//FarmAnimal[] farmAnimals = new FarmAnimal[] { new Cow(), new Chicken(), new Tractor()};
		Singable[] singables = new Singable[] {new Cow(), new Chicken(), new Tractor()};

		for (Singable singable : singables) {
			String name = singable.getName();
			String sound = singable.getSound();
			System.out.println("Old MacDonald had a farm, ee, ay, ee, ay, oh!");
			System.out.println("And on his farm he had a " + name + ", ee, ay, ee, ay, oh!");
			System.out.println("With a " + sound + " " + sound + " here");
			System.out.println("And a " + sound + " " + sound + " there");
			System.out.println("Here a " + sound + " there a " + sound + " everywhere a " + sound + " " + sound);
			System.out.println();
		}
		
		System.out.println("\nFOR SALE!! - Get'em while they're hot\n");
		
		Sellable[] sellables = new Sellable[] {new Egg(), new Pig()};
		
		for(Sellable sellable : sellables) {
			System.out.println(sellable.getName() + " for sale!: " + sellable.getPrice());
		}
	}
}