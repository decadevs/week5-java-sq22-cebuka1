package libarary.service.impl;

import libarary.enums.Role;
import libarary.model.Book;
import libarary.model.Borrower;
import libarary.model.Library;
import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LibraryServiceImpl2Test {

    private LibraryServiceImpl2 libraryService2;
    private Library library;

    @BeforeEach
    public void setUp() {
        libraryService2 = new LibraryServiceImpl2();
        Book book = new Book(1, "Test Book", "Test Author", 2);
        library = new Library(book);
    }


    @Test
    public void testGetBookOnFirstCome() {
        libraryService2.addToQueueOnFirstCome(new Borrower("Test Borrower", Role.TEACHER));
        String result = libraryService2.getBookOnFirstCome(library.getBook());
        assertEquals("Test Borrower has borrowed Test Book", result);
    }

    @Test
    public void testGetBookOnFirstComeEmptyQueue() {
        String result = libraryService2.getBookOnFirstCome(library.getBook());
        assertEquals("No one is on Queue", result);
    }
}