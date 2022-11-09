package com.techelevator.farm;

import java.math.BigDecimal;

public interface Sellable {

    //what does it mean to be sellable -- getPrice
    BigDecimal getPrice(); // any class that implements
    // this interface must provide what it means to getPrice
    String getName();

}

//we don't need to put abstract keyword in here because all interface
//methods are implicitly abstract
