package com.techelevator.farm;

/*
An interface is a contract.  Interface
are implemented.  Any class that implements
an interface must provide the method bodies (Override)
for the abstract methods listed in the interface
 */
public interface Singable {

    // abstract method -- no body
    // methods are implicitly public
    String getSound();
    String getName();
}
