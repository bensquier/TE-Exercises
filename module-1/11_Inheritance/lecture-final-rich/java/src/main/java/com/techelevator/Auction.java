package com.techelevator;

import java.util.ArrayList;
import java.util.List;

public class Auction {

	//Private Members
	private String itemForSale;
	private Bid currentHighBid;
	private List<Bid> allBids;
	
	//Public Properties
	public Bid getHighBid() {
		return currentHighBid;
	}

	public List<Bid> getAllBids() {
		return new ArrayList<>(allBids);
	}

	public String getItemForSale() {
		return itemForSale;
	}
	

	//CTOR
	public Auction(String itemForSale) {
		this.itemForSale = itemForSale;
		this.currentHighBid = new Bid("", 0);
		allBids = new ArrayList<>();
	}

	//Private Methods
	
	//Public Methods
	public boolean placeBid(Bid offeredBid) {
		allBids.add(offeredBid);
		boolean isCurrentWinningBid = false;
		if (offeredBid.getBidAmount() > currentHighBid.getBidAmount()) {
			currentHighBid = offeredBid;
			isCurrentWinningBid = true;
		}
		return isCurrentWinningBid;
	}


}
