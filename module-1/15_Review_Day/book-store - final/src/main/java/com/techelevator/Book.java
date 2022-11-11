package com.techelevator;

import java.math.BigDecimal;

public abstract class Book extends MediaItem{
    // attributes
    private String title;
    private String author;
    private String bookType;
    private int numberOfPages;
    private BigDecimal price;
    private static int count=0; // static means all objects share the same version

    // constructors
    public Book(String title, String author, String bookType, int numberOfPages, BigDecimal price) {
        super("Paper", false);
        this.title = title;
        this.author = author;
        this.bookType = bookType;
        this.numberOfPages = numberOfPages;
        this.price = price;
        count++;
    }

    public static int getCount() {
        return count;
    }

    // getters and setters
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getBookType() {
        return bookType;
    }

    public void setBookType(String bookType) {
        this.bookType = bookType;
    }

    public int getNumberOfPages() {
        return numberOfPages;
    }

    public void setNumberOfPages(int numberOfPages) {
        this.numberOfPages = numberOfPages;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    // any other methods
    @Override
    public String toString() {
        return  title + "   " +
                 author  + "   " +
                bookType + "   " +
                numberOfPages + "   " +
                price;
    }
}
