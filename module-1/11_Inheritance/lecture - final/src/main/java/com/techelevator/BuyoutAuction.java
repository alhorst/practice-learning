package com.techelevator;

/*
   Buyout Auction is child of Auction
   Will have all properties from Auction plus
   a new property called a buyoutPrice
   If someone bids the buyoutPrice, the auction ends and they win!
 */
public class BuyoutAuction extends Auction{
    private int buyoutPrice;

    // set the buyoutPrice when buyoutAuction object is created.
    public BuyoutAuction(String itemForSale, int buyoutPrice){
        super(itemForSale);
        this.buyoutPrice = buyoutPrice;
    }

    public int getBuyoutPrice(){
        return buyoutPrice;
    }

    /*
    provide my own version of what it means to placeBid
    Override the parent version
     */
     @Override
     public boolean placeBid (Bid offeredBid){
         boolean isCurrentWinningBid = false;
         if (offeredBid.getBidAmount() >= this.buyoutPrice){
             // if >= buyout price, the bid is the winning bid and
             // the auction ends
             isCurrentWinningBid = super.placeBid(offeredBid);
             System.out.println("Item is SOLD to " + offeredBid.getBidder() +
                     " for " + offeredBid.getBidAmount());
         } else {
             // what if bid is NOT at or above the buyoutPrice?
             isCurrentWinningBid = super.placeBid(offeredBid);
         }
         return isCurrentWinningBid;
     }
}
