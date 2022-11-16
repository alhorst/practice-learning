package com.techelevator.application;

import com.techelevator.logger.Logger;
import com.techelevator.models.BostonCreme;
import com.techelevator.models.ChocolateSprinkle;
import com.techelevator.models.Donut;
import com.techelevator.models.FilledStick;
import com.techelevator.ui.UserInput;
import com.techelevator.ui.UserOutput;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    //can now be called (write) in any method!
    private Logger logger = new Logger("donutlog.txt"); //check to see if file exists, if not, create

    public void run() {
        //read in file of donut first
        List<Donut> donutList = readFile();
        while(true) {
            UserOutput.displayHomeScreen();
            String choice = UserInput.getHomeScreenOption();
            System.out.println(choice);
            if(choice.equals("display")) {
                // display the items
                //write to log file
                logger.write(LocalDateTime.now() + "display called.");
            }
            else if(choice.equals("purchase")) {
                // make a purchase
                //write to log file
                logger.write(LocalDateTime.now() + "user made purchase.");
            }
            else if(choice.equals("exit")) {
                System.out.println("Thank you! Goodbye!");
                logger.write(LocalDateTime.now() + "user exited the program.");
                break;
            }
        }
    }

    public List<Donut> readFile() {
        //write to logger that we have read in data
        logger.write(LocalDateTime.now() + " reading in from file");
        List<Donut> list = new ArrayList<>();
        File file = new File("donuts.txt");
        if (!file.exists()) {
            System.out.println("File not found. Please try again.");
            System.exit(0);
        }
        try (Scanner reader = new Scanner(file)) {
            //while loop
            while (reader.hasNextLine()) {
                String line = reader.nextLine();
                //process data from the line
                //split our line to get data pieces out of it
                String[] splitLine = line.split(",");
                String type = splitLine[0]; //get the type of donut
                BigDecimal price = new BigDecimal(splitLine[1]);

                if (type.equals("Chocolate sprinkle")) {
                    list.add(new ChocolateSprinkle(price));
                } else if (type.equals("Boston creme")) {
                    list.add(new BostonCreme(price));
                } else if (type.equals("Triple chocolate filled stick")) {
                    list.add(new FilledStick(price));
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error! Unable to read file!");
            System.exit(0);
        }
        //System.out.println(list); //just for debugging
        return list;
    }
}
