package exceptions;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ExceptionDemo {
    public static void main(String[] args) {
        //Ask user for file
        Scanner userInput = new Scanner(System.in);
        File file;
        do {
            System.out.println("What is the file name>>> ");
            String userFile = userInput.nextLine();
            //Create a File object from string file name
            file = new File(userFile);
            if (!file.exists()) {
                System.out.println("File not found, try again>>> ");
            }
        } while (!file.exists());

        System.out.println("File open for reading...");
        //Create a Scanner object to connect program to OS file (stream)
        try {
            Scanner dataFile = new Scanner(file);
            //While there is content in file
            while (dataFile.hasNextLine()) {
                //pick up one line of text from file
                String line = dataFile.nextLine();

                startsWithT(line);

            }
        } catch (FileNotFoundException e) {
            System.out.println("Error reading from file!");;
        }
    }
    //does it start with letter T
    //if yes, throw an exception!

    public static void startsWithT(String line) {
        if (line.startsWith("T")) {
            try {
                throw new CapitalTException();
            } catch (CapitalTException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
