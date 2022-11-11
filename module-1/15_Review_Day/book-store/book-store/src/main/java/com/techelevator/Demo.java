package com.techelevator;

import java.util.ArrayList;
import java.util.List;

public class Demo {

    public static void main(String[] args) {

        List<Book> books = new ArrayList<>();

        ComicBook book = new ComicBook("Catwoman", "DC", 20);
        ComicBook book1 = new ComicBook("Batman", "DC", 15);

        ProgrammingBook book3 = new ProgrammingBook("The Pragmatic Programmer", "Andy Hunt and Dave Thomas", 320);
        ProgrammingBook book4 = new ProgrammingBook("Introduction to Java Programming", "Y. Daniel Liang", 546);
        ProgrammingBook book5 = new ProgrammingBook("Introducing Python", "Bill Lubanovic", 230);


        books.add(book);
        books.add(book1);
        books.add(book3);
        books.add(book4);
        books.add(book5);

        for (Book bookList : books) {
            System.out.println(bookList);
        }
    }
}
