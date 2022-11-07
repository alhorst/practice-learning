package com.techelevator;

public class BuyoutAuction extends Auction{

    private int buyoutPrice;

    public BuyoutAuction(String itemForSale, int buyoutPrice) {
        super(itemForSale); //first line always has to be super (so it can call to the parent constructor)
        this.buyoutPrice = buyoutPrice;
    }

    public int getBuyoutPrice() {
        return buyoutPrice;
    }

    @Override
    public boolean placeBid(Bid offeredBid) {
        boolean isCurrentWinningBid = false;
        if (offeredBid.getBidAmount() >= this.buyoutPrice) {
            isCurrentWinningBid = super.placeBid(offeredBid);
            System.out.println("Item is SOLD to " + offeredBid.getBidder() +
                    " for " + offeredBid.getBidAmount());
        }
        else {
            isCurrentWinningBid =  super.placeBid(offeredBid);
        }
        return isCurrentWinningBid;
    }
}
