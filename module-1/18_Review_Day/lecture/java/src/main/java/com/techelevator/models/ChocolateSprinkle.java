package com.techelevator.models;

import java.math.BigDecimal;

public class ChocolateSprinkle extends Donut {
    public ChocolateSprinkle(BigDecimal price) {
        super("Chocolate sprinkle", price);
    }

    @Override
    public String getType() {
        return super.getType();
    }

    @Override
    public BigDecimal getPrice() {
        return super.getPrice();
    }
}
