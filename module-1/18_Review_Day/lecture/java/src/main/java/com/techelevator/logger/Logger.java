package com.techelevator.logger;

import java.io.*;

public class Logger implements Closeable {
    //properties
    private File logFile; //holds the logFile object
    private PrintWriter writer; //writer instantiation of the PrintWriter class

    public Logger(String pathName) { //constructor will set up File object
        this.logFile = new File(pathName);
        //if this logFile exists, we want to append, if it doesn't we want to create
        if (this.logFile.exists()) {
            //append
            try {
                this.writer = new PrintWriter(new FileWriter(this.logFile), true);
            } catch (IOException e) {
                System.out.println("Error. Cannot write to file.");;
                }
        }
        //create file
        else {
            try {
                this.writer = new PrintWriter(this.logFile);
            } catch (FileNotFoundException e) {
                System.out.println("File not found. Created new file: " + this.logFile);
            }
        }

    }
    public void write(String message) {
        this.writer.println(message);
        this.writer.flush();
    }

    @Override
    public void close() throws IOException {

    }
}
