package com.techelevator;

public abstract class Book {
    private String title;
    private String author;
    private String genre;
    private int numberOfPages;
    private double price;

    public Book(String title, String author, String genre, int numberOfPages, double price) {
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.numberOfPages = numberOfPages;
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getGenre() {
        return genre;
    }

    public int getNumberOfPages() {
        return numberOfPages;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Title: " + title + "\n" + "Author: " + author + "\n" +
                "Genre: " + genre + "\n" +
                "Number of pages: " + numberOfPages + "\n" +
                "Price: $" + price;
    }
}
