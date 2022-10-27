package com.techelevator;

public class Lecture {

    /*
    1. Return the created array
    */
    public int[] returnArray() {
        int[] array = {80, 8080, 443};
        return array;
    }

    /*
    2. Return the first element of the array
    */
    public int returnFirstElement() {
        int[] portNumbers = {80, 8080, 443};
        return portNumbers[0];
    }

    /*
    3. Return the last element of the array
    */
    public int returnLastElement() {
        int[] portNumbers = {80, 8080, 443};
        return portNumbers[2];
    }

    /*
    4. Return the first element of the array from the parameters
    */
    public int returnFirstElementOfParam(int[] passedInArray) {
        return passedInArray[0];
    }

    /*
    5. Return the last element of the array from the parameters
    */
    public int returnLastElementOfParam(int[] passedInArray) {
        return passedInArray[passedInArray.length - 1];
    }

    /*
    6. Here, a variable is defined within a block. How can we get the value of that outside of the block in order to
       return it? There are a couple of different ways of doing this, what can you come up with?
    */
    public int returnVariableFromBlock(int number) {
        int result = 0;
        { // A new block with scoped variables

            result = number * 5;

        } // the result variable disappears here

        return result; // We want to return result here. How?
    }

    /*
    7. What will the variable result be at the end of the method? Change the number in the logic expression so that
       it returns true.
    */
    public boolean returnOperationInBlock() {
        int result = 5;

        {
            int multiplier = 10;
            result *= multiplier;
        }

        return result == 50; // <-- Change the number to match result and make this be true
    }

    /*
    8. Return the only variable that is in scope at the return statement.
    */
    public double returnInScopeVariable() {
        double one = 1.0;
        {
            double three = 3.0;
            one += three;
            {
                double four = 4.0;
                three = four - one;
                one++;
            }

            double five = 5.0;
            double eight = five + three;
        }

        return 5.0;
    }

    /*
    9. How many times do we go through this loop? Change the number in the logic expression so that it returns true.
    */
    public boolean returnCounterFromLoop() {

        int[] arrayToLoopThrough = {3, 4, 2, 9};

        int counter = 0; // Must be started outside the block so that have access to it after the block

        for (int i = 0; i < arrayToLoopThrough.length; i++) {
            counter++;
        }

        return counter == 4; // What should the number be to return true?
    }

    /*
    10. This loop is counting incorrectly. What needs to change in the loop for it to count properly?
    */
    public boolean returnCorrectCount() {
        int[] arrayToLoopThrough = {4, 23, 9};

        int counter = 0;

        //     Start;       Keep going while         Increment by one;
        for (int i = 0; i < arrayToLoopThrough.length; i++) {
            counter += 1;
        }

        return counter == 3;
    }

    /*
    11. This loop is counting incorrectly. What needs to change in the loop for it to count properly?
    */
    public boolean returnCountCorrectTimes() {
        int[] arrayToLoopThrough = {4, 23, 9, 4, 33};

        int counter = 0;

        //     Start;       Keep going while         Increment by one;
        for (int i = 0; i < arrayToLoopThrough.length; i++) {
            counter++;
        }

        return counter == 5;
    }

    /*
    12. We want this loop to only count every other item starting at zero. What needs to change in the loop for
        it to do that?
    */
    public boolean returnSumEveryOtherNumber() {
        int[] arrayToLoopThrough = {4, 3, 4, 1, 4, 6};

        int sum = 0;

        //     Start;       Keep going while       Increment by;
        for (int i = 0; i < arrayToLoopThrough.length; i += 2) {

            sum += arrayToLoopThrough[i];
        }

        return sum == 12;
    }
    /*
    13. Sammy the Squirrel realizes he needs snacks to go with his cigars if his party is going to be a success.
        He has decided to take a poll to determine whether his party should include:
        Freetoes, Cheeetoes, Doreetoes, or Chipps.  All answers are stored in an array -
        [numberOfFreetoesVotes, numberOfCheeetoesVotes, numberOfDoreetoesVotes, numberOfChippsVotes]
        Write a method that returns the most popular snack for the party (just return the highest number)

        Examples:
        [4, 12, 3, 5] -> 12
        [5, 3, 1, 0] -> 5
     */


    public int returnPopularSquirrelSnack(int[] snackNumbers) {
        int max = snackNumbers[0];

        for (int i = 0; i < snackNumbers.length; i++) {
            if (snackNumbers[i] > max) {
                max = snackNumbers[i];
            }
        }
        return max;
    }
    /*
    14. What good are cigars and snacks without drinks?  Sammy knows that his party goers either drink pepsi(p) or whiskey (w)
        Write a method that reads in an array of String and totals up how many water drinkers and how many whiskey drinkers
        he has attending his next party

        Examples:
        ['p', 'p', 'w', 'w', 'w'] -> [2, 3]
        ['w', 'w', 'w', 'w'] -> [0, 4]
     */

    public int[] returnTotalDrinks(char[] orders) {
        int sumWater = 0; //sum of each drink
        int sumWhiskey = 0;

        for (int i = 0; i < orders.length; i++) {
            if (orders[i] == 'p') {
                sumWater += 1;
            }
            if (orders[i] == 'w') {
                sumWhiskey += 1;
            }
        }
        return new int[]{sumWater, sumWhiskey};
    }

    /*
    15. Sally the Squirrel is still trying to collect data on the average number of cigars smoked.  Write a method
        that takes in the number of cigars each squirrel has smoked and calculate the average
        Examples:
        [5, 4, 3, 5, 5, 7, 1, 0] -> 3.75
        [2, 2, 1, 2, 3, 2, 1] -> 1.857
     */

    public double averageCigarUsage(int[] numberOfCigarsPerSquirrel) {

        double sumCigar = 0; //declare sum of cigars

        for (int i = 0; i < numberOfCigarsPerSquirrel.length; i++) {
            sumCigar += numberOfCigarsPerSquirrel[i]; //add each cigar to sum
        }
        double averageCigar = sumCigar / numberOfCigarsPerSquirrel.length; //find average

        return averageCigar;
    }
}
