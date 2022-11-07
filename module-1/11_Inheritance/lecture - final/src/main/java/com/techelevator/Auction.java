package com.techelevator;

import java.util.ArrayList;
import java.util.List;

public class Auction {

	// three properties
	private String itemForSale;  // String
	private Bid currentHighBid;  // A Bid object - composition
	private List<Bid> allBids;   // A list of Bid objects

	// constructor - requires a string to be passed in (parameters)
	public Auction(String itemForSale) {
		this.itemForSale = itemForSale;
		this.currentHighBid = new Bid("", 0);
		allBids = new ArrayList<>();
	}

	public boolean placeBid(Bid offeredBid) {
		allBids.add(offeredBid);
		boolean isCurrentWinningBid = false;
		if (offeredBid.getBidAmount() > currentHighBid.getBidAmount()) {
			currentHighBid = offeredBid;
			isCurrentWinningBid = true;
		}
		return isCurrentWinningBid;
	}

	public Bid getHighBid() {
		return currentHighBid;
	}

	public List<Bid> getAllBids() {
		return new ArrayList<>(allBids);
	}

	public String getItemForSale() {
		return itemForSale;
	}
}
