import antonio.geek.Entities.Book;
import antonio.geek.Entities.BorrowableBook;
import antonio.geek.Entities.Ebook;
import antonio.geek.Entities.LibraryDAO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.List;
import java.util.stream.Collectors;

public class Library {
    private LibraryDAO library;

    @BeforeEach
    public void setUp() {
        library = new LibraryDAO();
        library.addBook(new BorrowableBook("L'Inconnu", "Auteur A", 15.0, 100, false));
        library.addBook(new Ebook("Java Guide", "Auteur B", 20.0, 150, 10));
        library.addBook(new Book("Les Grandes Œuvres", "Auteur C", 35.0, 320));
    }

    @Test
    public void testAddBook() {
        Assertions.assertEquals(3, library.getBooks().size());
    }

    @Test
    public void testGetAvailableBorrowableBooks() {
        List<Book> result = library.getBooks().stream()
                .filter(book -> book instanceof BorrowableBook)
                .map(book -> (BorrowableBook) book)
                .filter(book -> !book.isBorrowed())
                .collect(Collectors.toList());

        Assertions.assertEquals(1, result.size());
    }

    @Test
    public void testGetTotalEbookSize () {
        double totalSize = library.getBooks().stream()
                .filter(book -> book instanceof Ebook)
                .map(book -> (Ebook) book)
                .mapToDouble(Ebook::getSizeInMb)
                .sum();
        Assertions.assertEquals(10, totalSize);
    }

    @Test
    public void testGetTilesPriceAbove20 () {
        List<String> titles = library.getBooks().stream()
                .filter(book -> book.getPrice() > 20)
                .map(Book::getTitle)
                .toList();
        Assertions.assertTrue(titles.contains("Les Grandes Œuvres"));
    }

    @Test
    public void testGetTotalBookPrices() {
        double total = library.getBooks().stream()
                .mapToDouble(Book::getPrice)
                .sum();
        Assertions.assertEquals(15.0 + 20.0 + 35.0, total);
    }
}
