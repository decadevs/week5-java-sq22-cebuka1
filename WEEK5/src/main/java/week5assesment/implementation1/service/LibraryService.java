package week5assesment.implementation1.service;

import week5assesment.implementation1.model.Book;
import week5assesment.implementation1.model.Person;

public interface LibraryService {

    void addBook(Book book);
    void addPersonToQueue(Person person);
    void borrowBooks();
    boolean returnBook(Book book);
}
