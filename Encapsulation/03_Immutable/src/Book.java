public class Book {
    private final String nameBook;
    private final String nameAuthorBook;
    private final int countPagesBook;
    private final int numberISBNBook;

    public Book(String nameBook, String nameAuthorBook, int countPagesBook, int numberISBNBook) {
        this.nameBook = nameBook;
        this.nameAuthorBook = nameAuthorBook;
        this.countPagesBook = countPagesBook;
        this.numberISBNBook = numberISBNBook;
    }

    public String getNameBook() {
        return nameBook;
    }

    public String getNameAuthorBook() {
        return nameAuthorBook;
    }

    public int getCountPagesBook() {
        return countPagesBook;
    }

    public int getNumberISBNBook() {
        return numberISBNBook;
    }
}
