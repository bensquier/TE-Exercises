package com.techelevator.auction;

import java.util.Scanner;

import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

public class App {

    private static final String API_URL = "http://localhost:3000/auctions";
    public static RestTemplate restTemplate = new RestTemplate();
    private static Scanner scanner;

    public static void main(String[] args) {
        init();
        run();
    }

    /**
     * Here to support testing
     */
    public static void init() {
        scanner = new Scanner(System.in);
    }

    public static Auction[] listAllAuctions() {
    	Auction[] auctions = restTemplate.getForObject(API_URL, Auction[].class);
    	return auctions;
    }

    public static Auction listDetailsForAuction() {
    	int auctionId = -1;
    	System.out.print("Please choose a auction to get details for: ");
    	try {
           auctionId = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException exception) {
            System.out.println("Error parsing the input for menu selection.");
        }
        System.out.println("");
    	Auction auction = restTemplate.getForObject(API_URL + "/" + auctionId, Auction.class);
    	return auction;
    }

    public static Auction[] findAuctionsSearchTitle() {
    	String auctionTitle = "";
    	System.out.println("Please enter the title of the auction you would like to find: ");
    	try {
    		auctionTitle = scanner.nextLine();
    	} catch (Exception e) {
    		System.out.println("Error parsing the input for menu selection.");
    	}
    	System.out.println("");
    	Auction[] auctions = restTemplate.getForObject(API_URL + "?title_like=" + auctionTitle , Auction[].class);
        return auctions;
    }

    public static Auction[] findAuctionsSearchPrice() {
    	double price = 0;
    	System.out.println("Please enter a price to find auctions: ");

    	try {
    		price = Double.parseDouble(scanner.nextLine());
    	} catch (NumberFormatException exception) {
            System.out.println("Error parsing the input for menu selection.");
        }
    	System.out.println("");
    	Auction[] auctions = restTemplate.getForObject(API_URL + "?currentBid_lte=" + price , Auction[].class);
    	return auctions;
    }

    private static void run() {
        int menuSelection = 999;

        printGreeting();

        while (menuSelection != 5) {
            try {
                menuSelection = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException exception) {
                System.out.println("Error parsing the input for menu selection.");
            }
            System.out.println("");
            if (menuSelection == 1) {
                printAuctions(listAllAuctions());
            } else if (menuSelection == 2) {
                printAuction(listDetailsForAuction());
            } else if (menuSelection == 3) {
                printAuctions(findAuctionsSearchTitle());
            } else if (menuSelection == 4) {
                printAuctions(findAuctionsSearchPrice());
            } else if (menuSelection == 5) {
                scanner.close();
                System.exit(0);
            } else {
                System.out.println("Invalid Selection");
            }
            menuSelection = 999;
            System.out.println("\nPress Enter to continue...");
            scanner.nextLine();
            printGreeting();
        }
    }

    private static void printGreeting() {
        System.out.println("");
        System.out.println("Welcome to Online Auctions! Please make a selection: ");
        System.out.println("1: List all auctions");
        System.out.println("2: List details for specific auction");
        System.out.println("3: Find auctions with a specific term in the title");
        System.out.println("4: Find auctions below a specified price");
        System.out.println("5: Exit");
        System.out.println("");
        System.out.print("Please choose an option: ");
    }

    private static void printAuctions(Auction[] auctions) {
        if (auctions != null) {
            System.out.println("--------------------------------------------");
            System.out.println("Auctions");
            System.out.println("--------------------------------------------");
            for (Auction auction : auctions) {
                System.out.println(auction.currentBidToString());
            }
        }
    }

    private static void printAuction(Auction auction) {
        if (auction != null) {
            System.out.println("--------------------------------------------");
            System.out.println("Auction Details");
            System.out.println("--------------------------------------------");
            System.out.println("Id: " + auction.getId());
            System.out.println("Title: " + auction.getTitle());
            System.out.println("Description: " + auction.getDescription());
            System.out.println("User: " + auction.getUser());
            System.out.println("Current Bid: " + auction.getCurrentBid());
            System.out.println("");
        }
    }

}
