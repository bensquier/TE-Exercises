package com.techelevator;

import java.util.ArrayList;
import java.util.List;

public class Application {

    public static void main(String[] args) {

        // Create a new general auction
        System.out.println("Starting a general auction");
        System.out.println("-----------------");

        Auction generalAuction = new Auction("Tech Elevator t-shirt");

        generalAuction.placeBid(new Bid("Josh", 1));
        generalAuction.placeBid(new Bid("Fonz", 23));
        generalAuction.placeBid(new Bid("Rick Astley", 13));
        //....
        //....
        // This might go on until the auction runs out of time or hits a max # of bids
        
        for(Bid bid: generalAuction.getAllBids()) {
        	System.out.println(bid.getBidder() + " offers: " + bid.getBidAmount());
        }
        
        System.out.println("Current General Auction Winner: " + generalAuction.getHighBid().getBidder());
        
        
     // The rules of a buyout auction automatically end
     // when the buyout price is met
        System.out.println();
        System.out.println("--------------");
        System.out.println("Buyout Auction");
        System.out.println();
        System.out.println();
        
        BuyoutAuction buyoutAuction = new BuyoutAuction("Tech Elevator Travel Mug",55);

        buyoutAuction.placeBid(new Bid("Rick Astley", 20));
        buyoutAuction.placeBid(new Bid("Michael Scott", 30));
        buyoutAuction.placeBid(new Bid("Ryan Howard", 75));
        buyoutAuction.placeBid(new Bid("Dwight Schrute", 31));
        //buyoutAuction.placeBid(new Bid("Ryan Howard", 75));
        
        for(Bid bid: buyoutAuction.getAllBids()) {
        	System.out.println(bid.getBidder() + " offers: " + bid.getBidAmount());
        }

        System.out.println("Current Buyout Auction Winner: " + buyoutAuction.getHighBid().getBidder() + " at: " + buyoutAuction.getHighBid().getBidAmount());
        
        System.out.println();
        System.out.println("--------------");
        System.out.println("Reserve Auction");
        System.out.println();
        System.out.println();

        ReserveAuction reserveAuction = new ReserveAuction("Tech Elevator Hat",80);

        reserveAuction.placeBid(new Bid("Ted Mosby", 35));
        reserveAuction.placeBid(new Bid("Marshall Erickson", 55));
        reserveAuction.placeBid(new Bid("Barney Stinson", 80));
        reserveAuction.placeBid(new Bid("Lily Erickson", 60));
        reserveAuction.placeBid(new Bid("Robin Sherbatsky", 85));
        
        for(Bid bid: reserveAuction.getAllBids()) {
        	System.out.println(bid.getBidder() + " offers: " + bid.getBidAmount());
        }
        
        System.out.println("Current Reserve Auction Winner: " + reserveAuction.getHighBid().getBidder() + " at: " + reserveAuction.getHighBid().getBidAmount());
        
        
        
        //WHAT IS THE REAL POWER OF INHERITANCE??
        //----------------------------------------
        // Aside from Auction instantiation and bid submissions
        //  The entire auction site could be reported on using 
    	//	just the code below for ALL subclasses of Auction

        System.out.println("\n----------------------------------------------------------------");
        System.out.println("    INHERITANCE:");
        System.out.println("----------------------------------------------------------------");
        System.out.println("Q: What is the power of inheritance and the \"IS A\" realtionship?");
        System.out.println("A: Look at the next block of code and the output it creates below!");
        System.out.println("----------------------------------------------------------------\n");
        
        List<Auction> myAuctions = new ArrayList<>();
        
        myAuctions.add(generalAuction);
        myAuctions.add(buyoutAuction);
        myAuctions.add(reserveAuction);
        
        //For every Auction type in myAuctions, report
        for(Auction a : myAuctions) {
        	
        	System.out.println("");
        	System.out.println("---------------------------");
        	System.out.println("Auction" + a.toString());
        	System.out.println("---------------------------");
        	
        	//For each bid in each Auction type, report bidders and bids
        	for(Bid bid: a.getAllBids()) {
            	System.out.println(bid.getBidder() + " offers: " + bid.getBidAmount());
            }
            
            System.out.println("Current Auction Winner: " + a.getHighBid().getBidder() + " at: " + a.getHighBid().getBidAmount());
            
        }
        
        
    }
}
