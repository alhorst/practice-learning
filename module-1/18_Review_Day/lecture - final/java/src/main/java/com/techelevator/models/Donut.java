package com.techelevator.models;

import java.math.BigDecimal;

public abstract class Donut {
    private String type;
    private BigDecimal price;

    public Donut(String type, BigDecimal price) {
        this.type = type;
        this.price = price;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Donut type: " + type + "  price: $" + price;
    }
}
