package libarary.service;

import libarary.enums.Role;
import libarary.model.Book;
import libarary.model.Borrower;
import libarary.model.Library;
import libarary.service.impl.LibraryServiceImpl;
import libarary.service.impl.LibraryServiceImpl2;

public class Main {
    public static void main(String[] args) {

        //Creating New Instance of Book
        Book book = new Book(02, "Fight Corruption In Nigeria is Dangerous", "Ngozi Okonjo-Iwela",1);
        Book book2 = new Book(03, "Who killed Dele Giwa", "Richard Akinnola",2);
        Library library = new Library(book);

        //This is with Priority
        LibraryServiceImpl libraryService = new LibraryServiceImpl();

        //This is without priority
        LibraryServiceImpl2 libraryServiceImpl2 = new LibraryServiceImpl2();

        //Adding Borrower To Queue With Priority
        libraryService.addBorrowerToQueue(new Borrower("Agbo Sunday", Role.JUNIOR_STUDENT));
        libraryService.addBorrowerToQueue(new Borrower("John Agene", Role.SENIOR_STUDENT));
        libraryService.addBorrowerToQueue(new Borrower("Uchenna Obi", Role.TEACHER));

        //Adding Borrower With Priority
        libraryServiceImpl2.addToQueueOnFirstCome(new Borrower("Mike Owen", Role.SENIOR_STUDENT));
        libraryServiceImpl2.addToQueueOnFirstCome(new Borrower("Osiki Segun", Role.TEACHER));
        libraryServiceImpl2.addToQueueOnFirstCome(new Borrower("Olutosin Olalaye", Role.JUNIOR_STUDENT));

        System.out.println("This is with Priority");
        System.out.println(libraryService.borrowBooks(library, book));
        System.out.println(libraryService.borrowBooks(library, book));
        System.out.println(libraryService.borrowBooks(library, book));
        System.out.println("****************************************");

        System.out.println("This is on a first come serve basis");
        System.out.println(libraryServiceImpl2.getBookOnFirstCome(book2));
        System.out.println(libraryServiceImpl2.getBookOnFirstCome(book2));
        System.out.println(libraryServiceImpl2.getBookOnFirstCome(book2));
        System.out.println("*********************************************");
    }
}