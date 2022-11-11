package com.techelevator;

public class ComicBook extends Book{

    public ComicBook(String title, String author, int numberOfPages) {
        super(title, author, "Comic Book", numberOfPages, 1.99);
    }
}
