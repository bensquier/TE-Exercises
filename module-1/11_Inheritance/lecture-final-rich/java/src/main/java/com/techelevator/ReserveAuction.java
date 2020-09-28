package com.techelevator;

/**
 * This class models an auction in which the seller has set a minimum sale price
 *  in advance (the 'reserve' price) and the final bid does not reach that price
 *  the item remains unsold.
 */
public class ReserveAuction extends Auction{
	
	private int reservePrice;
	
	//CTOR
	public ReserveAuction(String itemForSale, int reservePrice) {
		super(itemForSale);
		this.reservePrice = reservePrice;
	}
	
	/*
	 * This class overrides the default placeBid behavior of the parent class.
	 * If the offeredBid does not meet or exceed the reserve price, the bid
	 * is ignored.
	 */
	@Override
	public boolean placeBid(Bid offeredBid) {
		boolean isCurrentWinningBid = false;
		
		if(offeredBid.getBidAmount() >= reservePrice) {
			isCurrentWinningBid = super.placeBid(offeredBid);
		}
		
		
		return isCurrentWinningBid;
	}

}
