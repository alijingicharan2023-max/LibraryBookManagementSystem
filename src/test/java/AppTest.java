import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class AppTest {

    @Test
    void testLendBookSuccess() {
        Library lib = new Library();
        lib.addBook(1, "Java");

        boolean result = lib.lendBook(1);

        assertTrue(result);
    }

    @Test
    void testLendBookFailure() {
        Library lib = new Library();
        lib.addBook(1, "Java");

        lib.lendBook(1); // already lent
        boolean result = lib.lendBook(1);

        assertFalse(result);
    }

    @Test
    void testReturnBook() {
        Library lib = new Library();
        lib.addBook(1, "Java");

        lib.lendBook(1);
        boolean result = lib.returnBook(1);

        assertTrue(result);
    }
}
