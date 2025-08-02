package antonio.geek.Entities;

public class Ebook extends Book {
    private final double sizeInMb;

    public Ebook(String title, String author, double price, int pages, double sizeInMb) {
        super(title, author, price, pages);
        this.sizeInMb = sizeInMb;
    }

    public double getSizeInMb() {
        return sizeInMb;
    }

    @Override
    public String toString() {
        return super.toString() + " Ebook [ File size : " + sizeInMb + " ].";
    }
}
