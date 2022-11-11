package com.techelevator;

import java.math.BigDecimal;

public class ProgrammingBook extends Book{
    public ProgrammingBook(String title, String author, int numberOfPages) {
        super(title, author, "Programming Book", numberOfPages, new BigDecimal("89.99"));
    }
}
