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
		System.out.print("Please enter the path of a file or directory>>> ");
		String path = userInput.nextLine();

		File file = new File(path);
		if (file.exists()) {  // returns true if file or directory exists in the OS locations, otherwise returns false
			System.out.println("name: " + file.getName());
			System.out.println("Absolute path: " + file.getAbsolutePath());
			System.out.println("Canonical path: " + file.getCanonicalPath());
			if (file.isDirectory()){
				System.out.println("Type: directory");
			} else if (file.isFile()){
				System.out.println("Type: file");
			}
			System.out.println("Size: " + file.length());  // length (size) in number of bytes
		}
		System.out.println("***********************************");

		System.out.println("Let's create a new directory");
		System.out.print("Enter the path of the directory to create: ");
		path = userInput.nextLine();

		File newDirectory = new File(path); // create a new File object called newDirectory
		if (newDirectory.exists()){
			System.out.println("Sorry, " + newDirectory.getName() + " already exists");
		} else {
			// create a new directory!
			// mkdir is the command to create a new directory
			if (newDirectory.mkdir()) { // returns true if able to create
				System.out.println("Directory " + newDirectory.getName() + " was created!");
			} else {
				System.out.println("Could not create directory");
				System.exit(1);  // end the program gracefully
			}
		}
		/*
		  CREATE A FILE
		 */
		System.out.println(""); // just for spacing
		System.out.println("Now, let's put a file in the directory!");
		System.out.print("Enter a name for the file>>> ");
		String fileName = userInput.nextLine();
		File newFile = new File(newDirectory, fileName );

		// createNewFile is the command (method) to create a new file
		newFile.createNewFile();  // creates a file in the directory
		System.out.println();
		System.out.println("name: " + newFile.getName());
		System.out.println("Absolute path: " + newFile.getAbsolutePath());
		System.out.println("Size: " + newFile.length());
	}

}
