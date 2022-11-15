package com.techelevator.exceptions;
/*
Writing your own exception class, it needs to
extend from Exception.  Any class that extends
from Exception will be checked exceptions
 */
public class CapitalTException extends Exception{

    public CapitalTException(){
        super("There is a capital T at the beginning of this file!");
    }
}
