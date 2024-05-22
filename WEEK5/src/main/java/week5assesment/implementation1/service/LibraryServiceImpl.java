package week5assesment.implementation1.service;

import week5assesment.implementation1.model.Book;
import week5assesment.implementation1.model.Person;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class LibraryServiceImpl implements LibraryService{
    private final HashMap<String, Queue<Book>> books;
    private final HashMap<String, PriorityQueue<Person>> bookRequests;
    private final HashMap<Book, Person> borrowBooks;

    public LibraryServiceImpl(HashMap<String, Queue<Book>> books, HashMap<String, PriorityQueue<Person>> bookRequests, HashMap<Book, Person> borrowBooks) {
        this.books = books;
        this.bookRequests = bookRequests;
        this.borrowBooks = borrowBooks;
    }

    @Override
    public void addBook(Book book) {
        books.putIfAbsent(book.getTitle(), new LinkedList<>());
        books.get(book.getTitle()).add(book);

    }

    @Override
    public void addPersonToQueue(Person person) {
        String requestedBookTitle = person.getRequestBook().getTitle();
        bookRequests.putIfAbsent(requestedBookTitle, new PriorityQueue<>(new RoleComparator()));
        bookRequests.get(requestedBookTitle).add(person);

    }

    @Override
    public void borrowBooks() {
        for (String booktitle : books.keySet()){
            Queue<Book> bookQueue = books.get(booktitle);
            PriorityQueue<Person> requestQueue = bookRequests.get(booktitle);
            while (!bookQueue.isEmpty() && requestQueue != null && !requestQueue.isEmpty()){
                Book book = bookQueue.poll();
                Person person = requestQueue.poll();
                borrowBooks.put(book, person);
                assert person != null;
                System.out.println(person.getName() + " has borrowed " + book);

                if(requestQueue.isEmpty()){
                    bookRequests.remove(booktitle);
                }
            }
        }

    }

    @Override
    public boolean returnBook(Book book) {

        Person person = borrowBooks.remove(book);
        if(person == null)
            return false;
        books.get(book.getTitle()).add(book);
        return true;
    }

    public Queue<Book> getBooks(){
        Queue<Book> allBooks = new LinkedList<>();
        for(Queue<Book> bookQueue : books.values()){
            allBooks.addAll(bookQueue);
        }
        return allBooks;


    }
    public  HashMap<String, PriorityQueue<Person>> getBookRequests(){
        return bookRequests;
    }

    public boolean isBookBorrowedBy (Person person, Book book){
        return borrowBooks.get(book) != null && borrowBooks.get(book).equals(person);
    }


}

