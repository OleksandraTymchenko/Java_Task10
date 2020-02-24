package alex.com.task10;

import java.io.InvalidObjectException;
import java.util.Scanner;

import static alex.com.task10.Books.*;

public class Main {
    public static void main(String[] args) throws Exception {
        int i = 5;
        Book book1 = new Book(1, "The Old Man and the Sea", "Ernest Hemingway", "B & W Publishing", 1987, 324, 78);
        Book book2 = new Book(2, "A Walk in Amnesia", "O. Henry", "Ballantine Books", 2001, 90, 45);
        Book book3 = new Book(3, "Robin Hood", "Sally M. Stockton", "Ace Books", 1999, 342, 20);
        Book book4 = new Book(4, "A Kiss Before Dying", "Ira Levin", "Airiti Press", 2009, 420, 110);
        Book book5 = new Book(5, "Pride And Prejudice", "Jane Austen", "Armida Publications", 2004, 145, 90);

        Books books = new Books(i);
        books.addBook(book1);
        books.addBook(book2);
        books.addBook(book3);
        books.addBook(book4);
        books.addBook(book5);
        books.printBooks();

        System.out.println("Введите процент увеличения стоимости книг: ");
        Scanner sc = new Scanner(System.in);
        int procent = 0;
        try {
            procent = sc.nextInt();
        } catch (Exception e) {
            System.out.println("Sorry, enter a number");

        }
        books.changePrice(procent);
        System.out.println("---------------------------");
        books.printBooks();


        System.out.println("---------------------------");
        System.out.println("Введите имя автора: ");
        Scanner str = new Scanner(System.in);
        String line = str.nextLine();
        Books findAuthorBooks = new Books(i);
        findAuthorBooks.setBooks(books.searchBookAuthor(line));
        findAuthorBooks.printBooks();

        System.out.println("---------------------------");
        System.out.println("Введите год: ");
        int year = 0;
        try {
            year = sc.nextInt();
        } catch (Exception e) {
            System.out.println("Sorry, enter a number");

        }
        Books findBooksAfterYear = new Books(i);
        findBooksAfterYear.setBooks(books.searchBookYear(year));

        Book[] booksToCompare = {book1, book2, book3, book4, book5};
        compareAutorNames(booksToCompare);
        comparePuplisherNames(booksToCompare);
        comparePrices(booksToCompare);
        Serializator serializator = new Serializator();
        serializator.serialization(books);
        try {
            books = serializator.deseralization();
            books.printBooks();
        } catch (InvalidObjectException e) {
            e.printStackTrace();
        }

    }
}
