package com.techelevator;

public class Exercise02_BoardingGate {
    /*
    Local Jetways is a regional airline operating at local airports.
    They use a basic passenger manifest to represent seat occupancy on their plane.
        Each passenger seat is represented as an element in a boolean array.
        A value of TRUE indicates that seat is currently available.
        A value of FALSE indicates the seat is not available.
     */

    /*
    A nearby airport has an incoming flight from Local Jetways. As the passengers disembark, the gate
    attendant's first responsibility is to generate a new seating chart with each seat initially available.

    Implement the logic to generate a seating chart using the required number of seats. Make sure to indicate
    that each seat is initially available (TRUE).

    Note: The number of seats is guaranteed not to be negative.

    Examples:
    generateSeatingChart(7) → [true, true, true, true, true, true, true]
    generateSeatingChart(5) → [true, true, true, true, true]
    generateSeatingChart(2) → [true, true]
     */
    public boolean[] generateSeatingChart(int numberOfSeats) {
        boolean[] arraySeats = new boolean[numberOfSeats];//make new array for seats

        for (int i = 0; i < arraySeats.length; i++) {
            arraySeats[i] = true;
        }
        return arraySeats;
    }

    /*
    Once passengers begin boarding the plane, gate attendants need a way to determine how many available
    seats there are on the plane.

    Using the array provided, implement the logic to count the number of available seats in the seating chart.
    A seat is available if the value is TRUE.

    Examples:
    getAvailableSeatCount([true, false, false, false]) → 1
    getAvailableSeatCount([false, false, false, false, false, false]) → 0
    getAvailableSeatCount([true, true, true, false]) → 3
    getAvailableSeatCount([]) → 0
     */
    public int getAvailableSeatCount(boolean[] seatingChart) {
        int freeSeats = 0;

        for (int i = 0; i < seatingChart.length; i++) {
            if (seatingChart[i] == true) {
                freeSeats++;
            }
        }
        return freeSeats;
    }

    /*
    The crew determined that it would be nice to know how many rows on the plane are at full occupancy.
    Each row has three seats and a row is at full occupancy if all three seats have someone sitting in them.

    Using the boolean array, implement the logic to count the number of full rows on the plane.
    Note: A new row starts at every third element. For example, row one begins with index 0, row two begins with index 3, and so on.

    Examples:
    getNumberOfFullRows([false, false, false, true, true, true]) → 1
    getNumberOfFullRows([true, true, true, true, true, true]) → 0
    getNumberOfFullRows([false, true, true, false, true, true]) → 0
     */
    public int getNumberOfFullRows(boolean[] seatingChart) {

        int rowFull = 0; //initialize is the row full?
        int seatCount = 1; //initialize our seat count 1 2 3
        int falseCount = 0; //the row is only full if the false count is 3

        for (int i = 0; i < seatingChart.length; i++) {

            if (seatCount > 3) { //if seat count is greater than 3, set it back to 1 and reset our false counter
                seatCount = 1;
                falseCount = 0;
            }
            if (!seatingChart[i]) { //looking for false condition, use negation (instead of false) so it enters the if
                falseCount++; //if we find a false, increment the counter by one
            }
            if (falseCount == 3 && seatCount == 3) { //if false count and seat count are both 3 the row is full
                rowFull++;
            }

            seatCount++; //increment our seat counter by 1
        }

            return rowFull;
    }
}

