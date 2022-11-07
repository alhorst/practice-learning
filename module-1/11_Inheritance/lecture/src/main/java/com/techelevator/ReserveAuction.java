package com.techelevator;

public class ReserveAuction extends Auction {
    //ReserveAuction IS-A Auction but with a reserve price
    private int reservePrice;

    public ReserveAuction(String itemForSale, int reservePrice) {
        super(itemForSale);
        this.reservePrice = reservePrice;
    }

    public int getReservePrice(){
        return reservePrice;
    }

    //ReserveAuction > want to override the placeBid method to handle a reserve price

    @Override //we have method named the same in the child as in the parent
    public boolean placeBid(Bid offeredBid) {
        boolean isCurrentWinningBid = false;
        if (offeredBid.getBidAmount() >= reservePrice) {
            isCurrentWinningBid = super.placeBid(offeredBid); //method override, tells it to go run method
        }
        return isCurrentWinningBid;
    }

/*    public void printReserveAuction() {
        System.out.println("Current item is: " + reserveAuction.getItemForSale() +
                "\n\tcurrent bidder is: " + reserveAuction.getHighBid().getBidder() +
                " and the current price is " + reserveAuction.getHighBid().getBidAmount() + " and " +
                "the reserve price is " + reserveAuction.getReservePrice());*/
}
//override toString to print out a method that lists everything
