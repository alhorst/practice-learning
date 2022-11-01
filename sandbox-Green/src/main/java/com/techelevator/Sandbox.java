package com.techelevator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Sandbox {

    public static void main(String[] args) {
        List<String> names = new ArrayList<>(Arrays.asList("Bilbo", "Merry", "Sauron", "Gandalf"));


        List<String>  answers = fiveCharacterList(names);
        System.out.println(answers);

        String[] stringArray = {"Train", "Boat", "Car"};
        List<String> no4LetterList = no4LetterWords(stringArray);


    }

    /*
	 Given an array of Strings, return an ArrayList containing the same Strings in the same order
	 except for any words that contain exactly 4 characters.
	 no4LetterWords( {"Train", "Boat", "Car"} )  ->  ["Train", "Car"]
	 no4LetterWords( {"Red", "White", "Blue"} )  ->  ["Red", "White"]
	 no4LetterWords( {"Jack", "Jill", "Jane", "John", "Jim"} )  ->  ["Jim"]
	 */
    public static List<String> no4LetterWords(String[] stringArray) {
        return null;
    }
    /*
    1. write a method that returns a new List of only String that are 5 character long
     */
    public static List<String> fiveCharacterList(List<String> names){
        List<String> newList = new ArrayList<>();
        // loop through the elements
        for (String item: names){  // for each element item (type String) in the names list
             // if length of each string is 5
            if (item.length() == 5){
             // add element to newList
             newList.add(item);
            }
        }
        return newList;
    }

}
