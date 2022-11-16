package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class FindAndReplace {

    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);
        System.out.println("What word would you like to search?");
        String wordToSearch = userInput.nextLine();
        System.out.println("What word would you like to replace the search word with?");
        String wordReplace = userInput.nextLine();
        System.out.println("What is your source file path?");
        String filePath = userInput.nextLine();
        System.out.println("What is the destination (for output) file path?");
        String fileDestinationPath = userInput.nextLine();

        File sourceFile = new File(filePath);
        File destinationFile = new File(fileDestinationPath);

        try (Scanner fileInput = new Scanner(sourceFile); PrintWriter writer = new PrintWriter(destinationFile)) {
            while (fileInput.hasNextLine()) {
                String line = fileInput.nextLine();
                writer.println(line.replace(wordToSearch, wordReplace));
            }
        } catch (FileNotFoundException e) {
            System.out.println("This requested file was not found: " + sourceFile.getAbsolutePath());
            }
    }

}
