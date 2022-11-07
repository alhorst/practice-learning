package com.techelevator;

public class Application {

    public static void main(String[] args) {

        // Create a new general auction
        System.out.println("Starting a general auction");
        System.out.println("-----------------");

        Auction generalAuction = new Auction("Tech Elevator t-shirt");
        System.out.println("Current item is " +generalAuction.getItemForSale() +
                "\n\tcurrent bidder is " + generalAuction.getHighBid().getBidder() + "and the " +
                "current price is " + generalAuction.getHighBid().getBidAmount());
        generalAuction.placeBid(new Bid("Josh", 1));
        generalAuction.placeBid(new Bid("Fonz", 23));
        generalAuction.placeBid(new Bid("Rick Astley", 13));
        //....
        //....
        // This might go on until the auction runs out of time or hits a max # of bids
        //implicitly calling toString
        //generalAuction.getAllBids().toString()
        System.out.println(generalAuction.getAllBids());

        ReserveAuction reserveAuction = new ReserveAuction("Green tea mug", 5);
        System.out.println("Current item is: " + reserveAuction.getItemForSale() +
                "\n\tcurrent bidder is: " + reserveAuction.getHighBid().getBidder() +
                " and the current price is " +reserveAuction.getHighBid().getBidAmount() + " and " +
                "the reserve price is " + reserveAuction.getReservePrice());
        //in order for the bid to count, it must be greater than the reserve price
        reserveAuction.placeBid(new Bid("Eminem", 3));
    }
}
