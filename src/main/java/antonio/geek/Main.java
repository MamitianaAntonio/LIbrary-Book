package antonio.geek;
import antonio.geek.Entities.BorrowableBook;
import antonio.geek.Entities.Ebook;
import antonio.geek.Entities.LibraryDAO;

public class Main {
    public static void main(String[] args) {
        LibraryDAO libraryDAO = new LibraryDAO();

        libraryDAO.addBook(new BorrowableBook("Les Misérables", "Victor Hugo", 15.0, 15, true));
        libraryDAO.addBook(new BorrowableBook("Harry Potter", "J.K. Rowling", 22.0, 10, false));
        libraryDAO.addBook(new BorrowableBook("L’Étranger", "Albert Camus", 18.5, 8, false));
        libraryDAO.addBook(new BorrowableBook("1984", "George Orwell", 19.9, 11, true));
        libraryDAO.addBook(new BorrowableBook("Le Comte de Monte-Cristo", "Alexandre Dumas", 25.0, 18, false));
        libraryDAO.addBook(new Ebook("Introduction à Java", "Author1", 9.5, 120, 3));
        libraryDAO.addBook(new Ebook("Spring Boot in Action", "Author2", 24.0, 210, 8));
        libraryDAO.addBook(new Ebook("Clean Code", "Robert C. Martin", 28.0, 300, 5));

        System.out.println("Borrowable book and not borrow :");
        libraryDAO.getBorrowableBookNotBorrow().forEach(System.out::println);
        System.out.println("\n Total of ebook size :");
        System.out.println(libraryDAO.getTotalEbooksSize() + " MB");
        System.out.println("\n Get title book superior 20");
        libraryDAO.getExpensiveBooksTitle().forEach(System.out::println);
        System.out.println("\n Sum of all prices of books :");
        System.out.println(libraryDAO.getSumOfAllPriceBooks());
    }
}