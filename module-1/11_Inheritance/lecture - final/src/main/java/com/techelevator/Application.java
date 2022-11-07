package com.techelevator;

public class Application {

    public static void main(String[] args) {

        // Create a new general auction
        System.out.println("Starting a general auction");
        System.out.println("-----------------");

        // creating an instance of an Auction class object
        Auction generalAuction = new Auction("Tech Elevator t-shirt");
        System.out.println("Current item is " + generalAuction.getItemForSale() +
                " \n\tcurrent bidder is " + generalAuction.getHighBid().getBidder() +
                " and the current price is " + generalAuction.getHighBid().getBidAmount());

        generalAuction.placeBid(new Bid("Josh", 1));
        System.out.println("Current item is " + generalAuction.getItemForSale() +
                " \n\tcurrent bidder is " + generalAuction.getHighBid().getBidder() +
                " and the current price is " + generalAuction.getHighBid().getBidAmount());


        generalAuction.placeBid(new Bid("Fonz", 23));
        System.out.println("Current item is " + generalAuction.getItemForSale() +
                " \n\tcurrent bidder is " + generalAuction.getHighBid().getBidder() +
                " and the current price is " + generalAuction.getHighBid().getBidAmount());

        generalAuction.placeBid(new Bid("Rick Astley", 13));
        System.out.println("Current item is " + generalAuction.getItemForSale() +
                " \n\tcurrent bidder is " + generalAuction.getHighBid().getBidder() +
                " and the current price is " + generalAuction.getHighBid().getBidAmount());
        //....
        //....
        // This might go on until the auction runs out of time or hits a max # of bids
        // implicitly calling the toString
        // generalAuction.getAllBids().toString()
        System.out.println(generalAuction.getAllBids());


        ReserveAuction reserveAuction = new ReserveAuction("Green tea mug", 5);
        System.out.println("Current item is " + reserveAuction.getItemForSale() +
                // \n says enter key \t tab over 5 spaces
                " \n\tcurrent bidder is " + reserveAuction.getHighBid().getBidder() +
                " the current price is " + reserveAuction.getHighBid().getBidAmount() +
                " and the reserve price is " + reserveAuction.getReservePrice());

        // in order for the bid to count, if has to be greater than the reserve price!
        reserveAuction.placeBid(new Bid("Eminem", 7));
        System.out.println("Current item is " + reserveAuction.getItemForSale() +
                // \n says enter key \t tab over 5 spaces
                " \n\tcurrent bidder is " + reserveAuction.getHighBid().getBidder() +
                " the current price is " + reserveAuction.getHighBid().getBidAmount() +
                " and the reserve price is " + reserveAuction.getReservePrice());


        BuyoutAuction buyoutAuction = new BuyoutAuction("Fabulous Expo Marker", 12);
        buyoutAuction.placeBid(new Bid ("Madonna", 2));
        System.out.println("Current item is " + buyoutAuction.getItemForSale() +
                // \n says enter key \t tab over 5 spaces
                " \n\tcurrent bidder is " + buyoutAuction.getHighBid().getBidder() +
                " the current price is " + buyoutAuction.getHighBid().getBidAmount() +
                " and the buyout price is " + buyoutAuction.getBuyoutPrice());
    }
}
