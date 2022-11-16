package com.techelevator;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Lecture {

	public static void main(String[] args) throws IOException {

		Scanner userInput = new Scanner(System.in);

		/*
		 * The java.io.File class is a representation of file and directory path names.  It provides methods to inspect and
		 * modify file system objects.
		 *
		 * One benefit is that it compensates for differences in Windows and Unix use of '/' and '\' as directory delimiters.
		 *
		 * A new instance of File can be created from a String that contains a file system path
		 */

		System.out.println("Please enter the path of a file or directory>>> ");
		String path = userInput.nextLine();

		File file = new File(path);
		if (file.exists()) {
			System.out.println("File exists. Name: " + file.getName() + "\nAbsolute path: " + file.getAbsolutePath() +
					"\nCanonical path: " + file.getCanonicalPath());
			if (file.isDirectory()) {
				System.out.println("Type: directory");
			} else if (file.isFile()) {
				System.out.println("Type: file");
			}
			System.out.println("Size: " + file.length());
		}
		System.out.println("Let's create a new directory!\n Enter the path of the directory to create: ");
		path = userInput.nextLine();

		File newDirectory = new File(path); //create a new File object called newDirectory
		if (newDirectory.exists()) {
			System.out.println("Sorry, " + newDirectory.getName() + "already exists.");
		} else {
			//create new directory
			if (newDirectory.mkdir()) {
				System.out.println("Directory " + newDirectory.getName() + "was created.");
			} else {
				System.out.println("Could not create directory.");
				System.exit(1); //end the program
			}

		}
		//CREATE A FILE
		System.out.println();
		System.out.println("Let's put a file in the directory!");
		System.out.println("Please enter a file name>>> ");
		String fileName = userInput.nextLine();
		File newFile = new File(newDirectory, fileName);
		newFile.createNewFile();
		System.out.println();


	}
}
