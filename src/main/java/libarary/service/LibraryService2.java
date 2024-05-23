package libarary.service;

import libarary.model.Book;
import libarary.model.Borrower;

public interface LibraryService2 {

    void addToQueueOnFirstCome(Borrower borrower);

    String getBookOnFirstCome(Book bookTitle);

}
