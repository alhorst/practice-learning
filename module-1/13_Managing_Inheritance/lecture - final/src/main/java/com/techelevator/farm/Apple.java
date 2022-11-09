package com.techelevator.farm;

import java.math.BigDecimal;

public class Apple implements Sellable{

    @Override
    public BigDecimal getPrice() {
        //BigDecimal is how Java deals with MONEY!
        // created a pricePerApple variable (object)
        BigDecimal pricePerApple = new BigDecimal("0.49");
        return pricePerApple;
        // return (new BigDecimal("0.49"));
    }

    @Override
    public String getName() {
        return "Apple";
    }
}
