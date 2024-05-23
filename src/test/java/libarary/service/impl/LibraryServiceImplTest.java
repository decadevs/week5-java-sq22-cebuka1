package libarary.service.impl;

import libarary.enums.Role;
import libarary.model.Book;
import libarary.model.Borrower;
import libarary.model.Library;
import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LibraryServiceImplTest {

    private LibraryServiceImpl libraryService;
    private Library library;

    @BeforeEach
    public void setUp() {
        libraryService = new LibraryServiceImpl();
        Book book = new Book(1, "Test Book", "Test Author", 2);
        library = new Library(book);
    }

    @Test
    public void testBorrowBooks() {
        libraryService.addBorrowerToQueue(new Borrower("Test Borrower", Role.TEACHER));
        String result = libraryService.borrowBooks(library, library.getBook());
        assertEquals("Test Borrower has borrowed Test Book by Test Author", result);
    }

    @Test
    public void testBorrowBooksEmptyQueue() {
        String result = libraryService.borrowBooks(library, library.getBook());
        assertEquals("No borrower is on the queue", result);
    }

}