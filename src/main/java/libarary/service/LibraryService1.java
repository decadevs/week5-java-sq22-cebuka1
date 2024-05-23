package libarary.service;

import libarary.model.Book;
import libarary.model.Borrower;
import libarary.model.Library;

public interface LibraryService1 {

    void addBorrowerToQueue(Borrower borrower);

    String borrowBooks(Library library, Book book);
}
