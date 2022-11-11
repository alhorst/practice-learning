package com.techelevator;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Demo {
    public static void main(String[] args) {

//        printSomething();
        List<Book> bookList = new ArrayList<>();
        ComicBook superman = new ComicBook("Superman", "Stephen Chalmer", 88);
        ComicBook hulk = new ComicBook("The Hulk", "Rachel Leonard", 88);
        // because our bookList is made up of Book objects
        // we add book object -- but comicbooks are books, therefore we can add them!
        bookList.add(superman);
        bookList.add(hulk);
        // don't need to create an object, we can add anonymously
        bookList.add(new ProgrammingBook("Java", "Margaret Green", 700));
        bookList.add(new ProgrammingBook("PostgreSQL", "Eric Cameron", 400));
        bookList.add(new ProgrammingBook("FrontEnd Coding", "Mark Sweitzer", 250));

        System.out.println("Book count = " + Book.getCount());
        BigDecimal totalPrice = new BigDecimal("0");
        System.out.printf("%-20s %-20s %-20s %-10s %10s\n", "Name","Author","Genre","Pages","Price");
        for (int i = 0; i < bookList.size(); i++){
            System.out.printf("%-20s %-20s %-20s %-10d %10.2f\n",
                    bookList.get(i).getTitle(),
                    bookList.get(i).getAuthor(),
                    bookList.get(i).getBookType(),
                    bookList.get(i).getNumberOfPages(),
                    bookList.get(i).getPrice());
            totalPrice = totalPrice.add(bookList.get(i).getPrice());
        }

        System.out.printf("The total price is $%.2f\n" ,totalPrice);
        // for each loop
        System.out.println("using a for each loop");
        for (Book book : bookList){
            System.out.println(book); // sout(book) is the same as saying sout(book.toString());
        }
    }

    public void printSomething(){
        System.out.println("Hi");
    }
}
