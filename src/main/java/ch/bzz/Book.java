package ch.bzz;

public class Book {
    private String id;
    private String isbn;
    private String title;
    private String author;
    private String year;


    public Book(String id, String isbn, String title, String author, String year) {
        this.id = id;
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.year = year;
    }


    public String toString() {
        return String.format("%s: %s by %s (%s) [ISBN: %s]", id, title, author, year, isbn);
    }

}
