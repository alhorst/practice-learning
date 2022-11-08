package com.techelevator;

public class ReserveAuction extends Auction{

    // ReserveAuction IS-A Auction but with a reserve price
    // a reserve price is a minimum price needed to be reached
    // in order for the item to be sold
    private int reservePrice;  // specific property for Reserve Auctions

    public ReserveAuction(String itemForSale, int reservePrice) {
        super(itemForSale);
        this.reservePrice = reservePrice;
    }

    public int getReservePrice() {
        return reservePrice;
    }
    /*
    ReserveAuction -- I want to override the placeBid
    method to handle a reservePrice
    If the offeredBid amount >= reservePrice, then we count
    is as a bid -- run the placeBid in the parent class
     */
    @Override
    public boolean placeBid(Bid offeredBid){
        boolean isCurrentWinningBid = false;
        if (offeredBid.getBidAmount() >= reservePrice){
            isCurrentWinningBid = super.placeBid(offeredBid);
        }
        return isCurrentWinningBid;
    }
}
