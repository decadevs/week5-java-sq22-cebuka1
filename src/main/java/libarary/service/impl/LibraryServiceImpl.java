package libarary.service.impl;

import libarary.model.Book;
import libarary.model.Borrower;
import libarary.model.BorrowerComparator;
import libarary.model.Library;
import libarary.service.LibraryService1;

import java.util.PriorityQueue;

public class LibraryServiceImpl implements LibraryService1 {

    PriorityQueue<Borrower> borrowerOnQueue;

    public LibraryServiceImpl(){
        borrowerOnQueue = new PriorityQueue<>(new BorrowerComparator());
    }

    @Override
    public void addBorrowerToQueue(Borrower borrower) {
        borrowerOnQueue.add(borrower);
    }

    @Override
    public String borrowBooks(Library library, Book book) {
        if (borrowerOnQueue.isEmpty()){
            return "No borrower is on the queue";
        } else if (book.getBookQuantity() == 0) {
            return "Book Taken";
        }

        Borrower borrower = borrowerOnQueue.poll();
        book.setBookQuantity(book.getBookQuantity() -1);
        assert borrower != null;
        return borrower.getFullName() + " has borrowed " + book.getTitle() + " by " + book.getAuthor();
    }
}
