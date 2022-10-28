package com.techelevator;

public class Exercise03_Shirts {

    private final static char SMALL_TSHIRT = 'S';
    private final static char MEDIUM_TSHIRT = 'M';
    private final static char LARGE_TSHIRT = 'L';

    /*
    A t-shirt company rep from Top Threads just finished taking an order
    from a client and needs to key it into the system. The client ordered,
    3 Small shirts ('S'), 2 Medium shirts ('M'), and 1 Large shirt ('L').

    Implement the logic to reflect an order of 6 t-shirts.

    Examples:
    buildOrder() → ['S', 'S', 'S', 'M', 'M', 'L']
     */
    public char[] buildOrder() {
        return new char[]{SMALL_TSHIRT, SMALL_TSHIRT, SMALL_TSHIRT, MEDIUM_TSHIRT, MEDIUM_TSHIRT, LARGE_TSHIRT};
    }

    /*
    Another customer called in and is hosting a large networking event and
    needs a bulk order. Rather than indicate how many of each shirt they
    wanted, they've asked for as even distribution as possible.

    Implement the logic to generate an order representing as even a distribution
    as possible, for example: ('S', 'M', 'L', 'S', 'M', 'L', 'S', ...)

    Note: The number of shirts ordered is guaranteed to be non-negative.

    Examples:
    buildBulkOrder(6) → ['S', 'M', 'L', 'S', 'M', 'L']    
    buildBulkOrder(3) → ['S', 'M', 'L']
    buildBulkOrder(4) → ['S', 'M', 'L', 'S']
    buildBulkOrder(0) → []
     */
    public char[] buildBulkOrder(int numberOfShirts) {
    char[]shirtOrder = new char[numberOfShirts]; //make new array for shirts
        int shirtCount = 1; //three sizes, [1]=S, [2]=M, [3]=L, can't be 0 because that's for empty

        for (int i = 0; i < shirtOrder.length; i++) {
            if (shirtCount > 3) { //send it back to 1 to start counting SML again
                shirtCount = 1;
            }
            if (shirtCount == 3) {
                shirtOrder[i] = 'L';
            } else if (shirtCount == 2) {
                shirtOrder[i] = 'M';
            } else if (shirtCount == 1) {
                shirtOrder[i] = 'S';
            }
            shirtCount++; // one two three one two three
        }
        return shirtOrder;
    }

    /*
    The warehouse is out of small shirts and will only request more when the
    next order comes in that includes an 'S' shirt.

    Implement the logic to look through the next incoming order `char[] order`
    and return true if we need to place an order for Small shirts.

    Examples:
    placeRequest(['M', 'L', 'S']) → true
    placeRequest(['M', 'S', 'L']) → true
    placeRequest(['M', 'M', 'L']) → false
    placeRequest([]) → false
     */
    public boolean placeRequest(char[] order) {
        boolean smallShirt = false;
        for (int i = 0; i < order.length; i++) {
            if (order[i] == 'S') {
                smallShirt= true;
                break;
            }
        } return smallShirt;
    }
}
