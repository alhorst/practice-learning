package com.techelevator.exceptions;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

// want to read in from a file!
public class ExceptionDemo {
    public static void main(String[] args) {
        File file = askForFileName();

        System.out.println("file open for reading");
        //  create a scanner object to connect program to OS file (stream)
        try {  // checked exception because we HAVE to have try catch, or put throws on method
            Scanner dataFile = new Scanner(file); // read from the file
        //  while there is content in the file
            while (dataFile.hasNextLine()) {  // if there is more content to read in the file
             // pick up one line of text from file
                String line = dataFile.nextLine();  // picks up one line from the file

                startsWithT(line);
                checkIfInteger(line);
            }
        } catch (FileNotFoundException e) { // e just holds the FileNotFoundException object
            System.out.println("Error reading from file!");
        }
    } // end of main method

    public static File askForFileName(){
        // Ask user for a file name
        Scanner userInput = new Scanner(System.in);
        File file;  // created a stack variable, but no memory set aside in the heap
        do {
            System.out.print("Enter the file name >>> ");
            String filePath = userInput.nextLine();
            // create a File object from string file name
            file = new File(filePath);
            if (!file.exists()) {
                System.out.println("File not found -- try again");
            }
            // make sure file exists before going on?
        }while (!file.exists());  // figure out what our condition
        return file;
    }

    public static void startsWithT(String line)  {
        if (line.startsWith("T")){  // if (line.substring(0,1).equals("T")
            try {
                throw new CapitalTException();
            } catch (CapitalTException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static void checkIfInteger(String line){
        try { // check to see if line in file is an integer
            int number = Integer.parseInt(line);
        } catch (NumberFormatException e){
            System.out.println("Not a number!");
        }
    }


}
