package com.techelevator.logger;

import java.io.*;

public class Logger implements Closeable {
    // properties
    private File logFile;  // holds the logFile object
    private PrintWriter writer; // writer instantiation of the PrintWriter class

    public Logger(String pathName){  // constructor will set up File object
        this.logFile = new File(pathName);
        if (this.logFile.exists()){
        // if this logFile exists we want to append
            try {
                this.writer = new PrintWriter(new FileWriter(this.logFile, true));
            } catch (IOException e) {
                e.printStackTrace();  // maybe replace with sout?
            }
        }
        // if it doesn't, we want to create!
        else {
            try {
                this.writer = new PrintWriter(this.logFile);
            } catch (FileNotFoundException e) {
                e.printStackTrace();  // maybe replace with a sout?
            }
        }

    }

    public void write(String message) {
        this.writer.println(message);  // this puts the message in the buffer!
        this.writer.flush();
    }

    @Override
    public void close() throws IOException {
        this.writer.close();
    }
}
