import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import java.util.List;

public class LibraryTest {

    private Library library;

    @Before
    public void setUp() {
        library = new Library();
    }

    @Test
    public void addBookSuccessfully() {
        // Add a book named XYZ with author ABC
        library.addBook("978-1-2345-6789-0", "XYZ", "ABC", 2021);
        assertEquals(1, library.getBookCount());
    }

    @Test
    public void addBookWithSameISBNShouldFail() {
        // Add one book, then add another with the same ISBN
        library.addBook("978-1-2345-6789-0", "XYZ", "ABC", 2021);
        try {
            library.addBook("978-1-2345-6789-0", "Another Book", "ABC", 2022);
            fail("Should throw an error for duplicate ISBN");
        } catch (IllegalArgumentException e) {
            assertEquals("ISBN already exists", e.getMessage());
        }
    }
    @Test
    public void borrowBookSuccessfully() {
        library.addBook("978-1-2345-6789-0", "Another Book", "ABC", 2022);
        library.borrowBook("978-1-2345-6789-0");
        // After borrowing, the book should not be available
        assertFalse(library.getBook("978-1-2345-6789-0").isAvailable());
    }

    @Test
    public void borrowUnavailableBookShouldFail() {
        library.addBook("978-1-2345-6789-0", "Another Book", "ABC", 2022);
        library.borrowBook("978-1-2345-6789-0"); // Borrow first time
        try {
            library.borrowBook("978-1-2345-6789-0"); // Try to borrow again
            fail("Should throw an error when trying to borrow an unavailable book");
        } catch (IllegalArgumentException e) {
            assertEquals("Book is not available for borrowing", e.getMessage());
        }
    }

    @Test
    public void returnBookSuccessfully() {
        library.addBook("978-1-2345-6789-0", "XYZ", "ABC", 2021);
        library.borrowBook("978-1-2345-6789-0"); // Borrow the book
        library.returnBook("978-1-2345-6789-0"); // Return the book
        assertTrue(library.getBook("978-1-2345-6789-0").isAvailable()); // Check if the book is available again
    }

    @Test
    public void returnBookThatWasNotBorrowedShouldFail() {
        try {
            library.returnBook("978-1-2345-6789-0"); // Try to return it without borrowing
            fail("Should throw an error when trying to return a book that was not borrowed");
        } catch (IllegalArgumentException e) {
            assertEquals("Book was not borrowed or does not exist", e.getMessage());
        }
    }



    @Test
    public void displayAvailableBooksAfterBorrowing() {
        // Add two books to the library
        library.addBook("978-1-2345-6789-0", "XYZ", "ABC", 2021);
        library.addBook("978-0-1234-5678-9", "Another Book", "DEF", 2020);
        
        // Borrow one book
        library.borrowBook("978-1-2345-6789-0"); 
        
       
        System.out.println("Available Books after borrowing:");
        library.displayAvailableBooks(); // This will print the available books

       
        List<Book> availableBooks = library.displayAvailableBooks();
        
        assertEquals(1, availableBooks.size()); // Only one book should be available
        
        assertEquals("Another Book", availableBooks.get(0).getTitle()); 
    }

    

}
