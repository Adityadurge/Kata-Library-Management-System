import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Book {
    private String isbn;
    private String title;
    private String author;
    private int year;
    private boolean isAvailable;

    // Book constructor
    public Book(String isbn, String title, String author, int year) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.year = year;
        this.isAvailable = true; 
    }

    // Getter for ISBN
    public String getIsbn() {
        return isbn;
    }
    
    public boolean isAvailable()
    {
        return  isAvailable;
    }

    public void borrow() {
        isAvailable = false;
    }

    public void returnBook() {
        isAvailable = true; 
    }


    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author; 
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

    public void borrowBook(String isbn) {
        Book book = books.get(isbn);
        if (book == null || !book.isAvailable()) {
            throw new IllegalArgumentException("Book is not available for borrowing");
        }
        book.borrow(); 
    }
    // return book detail using isbn
    public Book getBook(String isbn) {
        return books.get(isbn);
    }
    // return book functionality
    public void returnBook(String isbn) {
        Book book = books.get(isbn);
        if (book == null || book.isAvailable()) {
            throw new IllegalArgumentException("Book was not borrowed or does not exist");
        }
        book.returnBook(); 
    }


    public List<Book> displayAvailableBooks() {
        List<Book> availableBooks = new ArrayList<>();
        for (Book book : books.values()) {
            if (book.isAvailable()) {
                availableBooks.add(book);
            }
        }
    
        if (availableBooks.isEmpty()) {
            System.out.println("No books are available.");
        } else {
            System.out.println("Available Books:");
            for (Book book : availableBooks) {
                System.out.println("ISBN: " + book.getIsbn() + ", Title: " + book.getTitle() + ", Author: " + book.getAuthor());
            }
        }
    
        return availableBooks; 
    }
    
    
}
