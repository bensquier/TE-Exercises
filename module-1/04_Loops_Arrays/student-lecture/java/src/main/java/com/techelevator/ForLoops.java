package com.techelevator;

public class ForLoops {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// How many time do I want to do my work?
		int iterations = 10;
		
		
		//Do my work #iterations times
		for (int i =0; i < iterations; i++) {
			System.out.println(i);
		}
		
	 
		System.out.println("--- lets try pre-increment ----");
		
		for (int i =0; i < iterations; ++i) {
			System.out.println(i);
	}
		
		boolean run = true;
		int counter = 10;
		
		while(run) {
			
			
			
			System.out.println("I am running #" + counter);
			
			if(counter == 10) {
				run = false;
			}	else {
				counter++;
			}
		}
	}
}
		
//		run = true;
//		counter = 10;
//		
//		do {
//		
//		
//			counter++;
//			System.out.println("I am running #" + counter);
//			
//			if(counter == 10) {
//				run = false;
//			}
//	} while(run); 
//
//	}
//		
//	}
		
