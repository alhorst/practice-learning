package com.techelevator;

public class Lecture {

    public void method() { // method header -- public - means anyone can access this method
        // void - return data type
        // method -- name of the method
        // declaration of an array of how many candy pieces for each of my 4 kids
        // data type
        int [] candyCount = new int[4]; //4 is how many values are being stored in array
        candyCount[0] = 156;
        candyCount[1] = 130;
        candyCount[2] = 245;
        candyCount[3] = 32;


        int candyTotal = 0; //candyCount[0] + candyCount[1] + candyCount[2] + candyCount[3];
        for (int i = 0; i < candyCount.length; i++){
            candyTotal = candyTotal + candyCount[i];  // candyTotal += candyCount[i];
        }
        System.out.println("Total pieces of candy for the Green kids: " + candyTotal);
    }

    /*
    1. Return the created array
    */
    public int[] returnArray() {
        // declared an array and initialized it
        int[] array = { 80, 8080, 443 };
        return array;
    }

    /*
    2. Return the first element of the array
    */
    public int returnFirstElement() {
        int[] portNumbers = { 80, 8080, 443 };
        return portNumbers[0];
    }

    /*
    3. Return the last element of the array
    */
    public int returnLastElement() {
        int[] portNumbers = { 80, 8080, 443 };
        return portNumbers[2]; // return portNumbers[portNumbers.length - 1];
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
        int result;
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
            result *= multiplier; // result = result * multiplier;
        }
        int correctAnswer = 50;
        return result == correctAnswer; // <-- Change the number to match result and make this be true
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

        return one;
    }

    /*
    9. How many times do we go through this loop? Change the number in the logic expression so that it returns true.
    */
    public boolean returnCounterFromLoop() {

        int[] arrayToLoopThrough = { 3, 4, 2, 9 };

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
        int[] arrayToLoopThrough = { 4, 23, 9 };

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
        int[] arrayToLoopThrough = { 4, 23, 9, 4, 33 };

        int counter = 0;

        //     Start;       Keep going while         Increment by one;
        for (int i = 0; i < arrayToLoopThrough.length; i++) {
            counter = counter + 1;
        }

        return counter == 5;
    }

    /*
    12. We want this loop to only count every other item starting at zero. What needs to change in the loop for
        it to do that?
    */
    public boolean returnSumEveryOtherNumber() {
        int[] arrayToLoopThrough = { 4, 3, 4, 1, 4, 6 };

        int sum = 0;

        //     Start;       Keep going while       Increment by;
        for (int i = 0; i < arrayToLoopThrough.length; i +=  2) {
            sum = sum + arrayToLoopThrough[i];
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


    public int returnPopularSquirrelSnack(int[] snackNumbers){
        int maxNumber = 0;
        // loop to loop through the array
        for(int i = 0; i < snackNumbers.length; i++ ){

        // compare each value to maxNumber
            if(snackNumbers[i] > maxNumber){
        // if value > maxNumber, change maxNumber = value
                maxNumber = snackNumbers[i];
            }
        }
        return maxNumber; // return maxNumber
    }
    /*
    14. What good are cigars and snacks without drinks?  Sammy knows that his party goers either drink pepsi(p) or whiskey (w)
        Write a method that reads in an array of char and totals up how many pepsi drinkers and how many whiskey drinkers
        he has attending his next party

        Examples:
        ['p', 'p', 'w', 'w', 'w'] -> [2, 3]
        ['w', 'w', 'w', 'w'] -> [0, 4]
     */

    public int[] returnTotalDrinks(char[] orders){
        // create a variable to hold pepsiCount
        int pepsiCount = 0;
        // create a variable to hold the whiskeyCount
        int whiskeyCount = 0;
        // loop through the array called orders
        for(int i = 0; i < orders.length; i++) {
            // if value == 'p', add 1 to pepsiCount
            if (orders[i] == 'p'){
                pepsiCount++;
            }
            // if value == 'w', add 1 to whiskeyCount
            if (orders[i] == 'w'){
                whiskeyCount++;
            }
        }
        // after loops ends, send back new array with the pepsiCount and the whiskeyCount loaded in the elements
        int[] result = {pepsiCount, whiskeyCount};
        return result;
    }

    /*
    15. Sally the Squirrel is still trying to collect data on the average number of cigars smoked.  Write a method
        that takes in the number of cigars each squirrel has smoked and calculate the average
        Examples:
        [5, 4, 3, 5, 5, 7, 1, 0] -> 3.75
        [2, 2, 1, 2, 3, 2, 1] -> 1.857
     */

    public double averageCigarUsage(int[] numberOfCigarsPerSquirrel){
        // declare a variable to hold the sum
        // loop through the array and add all values to sum
        // after the loop, divide sum / how many elements are in the array
        return 0.00;
    }
}
