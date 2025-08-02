package antonio.geek.Entities;

public class BorrowableBook extends Book {
    private boolean isBorrowed;

    public BorrowableBook(String title, String author, double price, int pages, boolean isBorrowed) {
        super(title, author, price, pages);
        this.isBorrowed = isBorrowed;
    }

    public boolean isBorrowed() {
        return isBorrowed;
    }

    public void borrow() {
        isBorrowed = true;
    }
}
