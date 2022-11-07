package com.techelevator;

public class Bid {

	private String bidder;
	private int bidAmount;

	public Bid(String bidder, int bidAmount) {
		this.bidder = bidder;
		this.bidAmount = bidAmount;
	}

	public String getBidder() {
		return bidder;
	}

	public int getBidAmount() {
		return bidAmount;
	}

	@Override // overriding the toString method from Object
	public String toString() {
		return "Bid{" +
				"bidder='" + bidder + '\'' +
				", bidAmount=" + bidAmount +
				'}';
	}
}
