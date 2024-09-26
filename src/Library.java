import java.util.HashMap;
import java.util.Map;

class Book {
    private String isbn;
    private String title;
    private String author;
    private int year;

    // Book constructor
    public Book(String isbn, String title, String author, int year) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.year = year;
    }

    // Getter for ISBN
    public String getIsbn() {
        return isbn;
    }
}

class Library {
    private Map<String, Book> books;

    public Library() {
        books = new HashMap<>();
    }

    // Add a new book
    public void addBook(String isbn, String title, String author, int year) {
        if (books.containsKey(isbn)) {
            throw new IllegalArgumentException("ISBN already exists");
        }
        books.put(isbn, new Book(isbn, title, author, year));
    }

    // Get number of books
    public int getBookCount() {
        return books.size();
    }
}
