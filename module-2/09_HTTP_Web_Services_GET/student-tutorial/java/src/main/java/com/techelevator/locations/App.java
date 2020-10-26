package com.techelevator.locations;

import java.util.Scanner;

import org.springframework.web.client.RestTemplate;

import com.techelevator.models.Location;
import com.techelevator.services.ConsoleService;
import com.techelevator.services.LocationService;

public class App {

	private static final String API_URL = "http://localhost:3000/locations";
    private static RestTemplate restTemplate = new RestTemplate();

	
	public static void main(String[] args) {
		run();
	}
	
	public static Location[] requestLocations() {
		return restTemplate.getForObject(API_URL , Location[].class);
	}
	
	public static Location requestLocationById(int id) {
		return restTemplate.getForObject(API_URL + "/" + id, Location.class);
	}

	public static void run() {
		Location[] locations = requestLocations();
		Scanner scanner = new Scanner(System.in);
		int menuSelection = 999;
		int idSelection = -1;

		printMainMenu();
		
		while(menuSelection != 0) {
            try {
                menuSelection = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException exception) {
                System.out.println("Error parsing the input for menu selection.");
            }
            System.out.println("");
			if (menuSelection == 1) {
				printLocations(requestLocations());
				try {
	                idSelection = Integer.parseInt(scanner.nextLine());
	                
	                if(idSelection > 0 && idSelection <= locations.length) {
						printLocation(requestLocationById(idSelection));
	                } else {
	                	System.out.println("Invalid Location Id.");
	                }
	            } catch (NumberFormatException exception) {
	                System.out.println("Error parsing the input for menu selection.");
	            }
			} else if (menuSelection == 0) {
				scanner.close();
				System.exit(0);
			} else {
				// defensive programming: anything else is not valid
				System.out.println("Invalid Selection");
			}
		}
	}
	
	public static void printMainMenu() {
        System.out.println("");
        System.out.println("Welcome to Tech Elevator Locations. Please make a selection: ");
        System.out.println("1: List Tech Elevator Locations");
        System.out.println("0: Exit");
        System.out.println("");
        System.out.print("Please choose an option: ");
	}

	public static void printLocations(Location[] locations) {
	    System.out.println("--------------------------------------------");
	    System.out.println("Locations");
	    System.out.println("--------------------------------------------");
	    for (Location location : locations) {
	        System.out.println(location.getId() + ": " + location.getName());
	    }
	    System.out.println("");
	    System.out.println("Please enter a location id to get the details: ");
	}
	
	public static void printLocation(Location location) {
        System.out.println("");
        System.out.println("--------------------------------------------");
        System.out.println("Location Details");
        System.out.println("--------------------------------------------");
        if(location == null){
            System.out.println("No locations to print");
        } else {
            System.out.println("Id: " + location.getId());
            System.out.println("Name: " + location.getName());
            System.out.println("Address: " + location.getAddress());
            System.out.println("City: " + location.getCity());
            System.out.println("State: " + location.getState());
            System.out.println("Zip: " + location.getZip());
        }
    }

}
