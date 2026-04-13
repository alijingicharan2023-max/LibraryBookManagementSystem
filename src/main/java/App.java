import java.util.*;

class Book {
    int id;
    String title;
    boolean isAvailable;

    Book(int id, String title) {
        this.id = id;
        this.title = title;
        this.isAvailable = true;
    }
}

class Library {
    List<Book> books = new ArrayList<>();

    void addBook(int id, String title) {
        books.add(new Book(id, title));
    }

    void listBooks() {
        for (Book b : books) {
            System.out.println(b.id + " - " + b.title + " - " +
                (b.isAvailable ? "Available" : "Lent"));
        }
    }

    boolean lendBook(int id) {
        for (Book b : books) {
            if (b.id == id && b.isAvailable) {
                b.isAvailable = false;
                return true;
            }
        }
        return false;
    }

    boolean returnBook(int id) {
        for (Book b : books) {
            if (b.id == id && !b.isAvailable) {
                b.isAvailable = true;
                return true;
            }
        }
        return false;
    }
}

public class App {
    public static void main(String[] args) {
        Library lib = new Library();

        lib.addBook(1, "Java");
        lib.addBook(2, "Python");

        System.out.println("Before Lending:");
        lib.listBooks();

        lib.lendBook(1);

        System.out.println("\nAfter Lending:");
        lib.listBooks();
    }
}