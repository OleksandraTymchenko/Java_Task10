package alex.com.task10;

import java.io.Serializable;
import java.util.Arrays;

public class Books implements Serializable {


    public Book[] books;
    private int countBooks = 0;

    public Books(int i) {
        books = new Book[i];
    }

    public void compareAuthorNames(Book[] books) {
        Arrays.sort(books, new AuthorNameCompare());
    }

    public static void comparePublisherNames(Book[] books) {
        Arrays.sort(books, new PublisherNamesCompare());
    }

    public static void comparePrices(Book[] books) {
        Arrays.sort(books, new PriceCopmpare());
    }

    public Book[] getBooks() {
        return books;
    }

    public void setBooks(Book[] books) {
        this.books = books;
    }

    public void addBook(Book book) {
        if (countBooks == books.length) {
            return;
        }
        books[countBooks++] = book;
    }

    public void printBooks() {
        if (countBooks == 0) {
            System.out.println("No results found");
        }
        for (Book elem : books) {
            System.out.println(elem);
        }
    }

    public void changePrice(int x) {
        Book[] newPriceBooks = new Book[books.length];
        for (int i = 0; i < books.length; i++) {
            int oldPrice = books[i].getPrice();
            int newPrice = oldPrice * (100 + x) / 100;
            books[i].setPrice(newPrice);
        }
    }

    public Book[] searchBookAuthor(String str) {
        Book[] search = new Book[books.length];
        int count = 0;
        for (Book elem : books) {
            if (elem.getAuthor().equals(str)) {
                search[count] = elem;
                count++;
            }
        }
        return Arrays.copyOf(search, count);
    }

    public Book[] searchBookYear(int y) {
        Book[] search = new Book[books.length];
        int count = 0;
        for (Book elem : books) {
            if (elem.getYear() > y) {
                search[count] = elem;
                count++;
            }
        }
        return Arrays.copyOf(search, count);
    }
}
