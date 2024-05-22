package week5assesment.implementation2.service;

import week5assesment.implementation2.model.Book;
import week5assesment.implementation2.model.Person;
public interface LibraryService {

        void addBook(Book book);
        void addPersonToQueue(Person person);
        void borrowBooks();
        boolean returnBook(Book book);
    }
