package com.techelevator.application;

import com.techelevator.logger.Logger;
import com.techelevator.models.Chocolate;
import com.techelevator.models.CreamStick;
import com.techelevator.models.Donut;
import com.techelevator.models.Sprinkled;
import com.techelevator.ui.UserInput;
import com.techelevator.ui.UserOutput;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    // can now be called (write) in any method!
    private Logger logger = new Logger("donutLog.txt");

    public void run() {
        // read in file of donuts first!
        List<Donut> donutList = readFile();  // put the reading of the file in a method!
        while(true) {  // infinite loop
            UserOutput.displayHomeScreen();  // Class name.method name --
            String choice = UserInput.getHomeScreenOption();

            if(choice.equals("display")) {
                logger.write(LocalDateTime.now() + " - display called");
                // display the items
            }
            else if(choice.equals("purchase")) {
                // make a purchase
            }
            else if(choice.equals("exit")) {
                try {
                    logger.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                // good bye
                break; // exit the loop!
            }
        }
    }

    public List<Donut> readFile() {
        // write to the logger that we have read in data
        logger.write(LocalDateTime.now() + " - reading in from file");
        List<Donut> list = new ArrayList<>();
        // connect my code to the file
        File file = new File("donuts.txt");
        if (!file.exists()){
            System.out.println("Error reading file - program exiting!");
            System.exit(0);
        }
        try (Scanner reader = new Scanner(file)){ // try with resources
        // while loop
            while (reader.hasNextLine()){
                String line = reader.nextLine();
                // process the data from the line
                // split our line to get the data pieces out of it
                String [] splitLine = line.split(","); // an array of strings
                String type = splitLine[0]; // get the type of donut
                BigDecimal price = new BigDecimal(splitLine[1]); // get the price of donut
                if (type.equals("Chocolate")){
                    list.add(new Chocolate(price));
                }
                else if (type.equals("Cream Stick")){
                    list.add(new CreamStick(price));
                }
                else if (type.equals("Sprinkled")){
                    list.add(new Sprinkled(price));
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error -- unable to read in file!");
            System.exit(0);
        }
//        System.out.println(list); // not pretty, just for debugging purposes
        return list;
    }
    
}
