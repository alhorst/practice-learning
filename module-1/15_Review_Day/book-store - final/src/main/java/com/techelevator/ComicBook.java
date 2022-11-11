package com.techelevator;

import java.math.BigDecimal;

public class ComicBook extends Book{

    public ComicBook(String title, String author, int numberOfPages) {
        super(title, author, "Comic Book", numberOfPages, new BigDecimal("1.99"));
    }
}
