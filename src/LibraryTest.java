import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

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
}
