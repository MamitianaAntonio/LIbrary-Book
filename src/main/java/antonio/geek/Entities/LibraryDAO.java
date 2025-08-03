package antonio.geek.Entities;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LibraryDAO {
    List<Book> books;

    public LibraryDAO() {
        this.books = new ArrayList<>();
    }

    public List<Book> getBooks() {
        return books;
    }

    public void addBook(Book book) {
        this.books.add(book);
    }

    public List<BorrowableBook> getBorrowableBookNotBorrow () {
        return books.stream()
                .filter(book -> book instanceof BorrowableBook)
                .map(book -> (BorrowableBook) book)
                .filter(book -> !book.isBorrowed())
                .collect(Collectors.toList());
    }

    public double getTotalEbooksSize () {
        return books.stream()
                .filter(book -> book instanceof Ebook)
                .map(book -> (Ebook) book)
                .mapToDouble(Ebook::getSizeInMb)
                .sum();
    }

    public List<String> getExpensiveBooksTitle () {
        return books.stream()
                .filter(book -> book.getPrice() > 20)
                .map(Book::getTitle)
                .collect(Collectors.toList());
    }

    public double getSumOfAllPriceBooks () {
        return books.stream().mapToDouble(Book::getPrice).sum();
    }
}
