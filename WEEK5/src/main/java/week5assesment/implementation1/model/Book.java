package week5assesment.implementation1.model;

public class Book {
    private final String title;
    private final String author;

    public Book(String title, String author, String author1) {
        this.title = title;
        this.author = author1;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                '}';
    }
}
