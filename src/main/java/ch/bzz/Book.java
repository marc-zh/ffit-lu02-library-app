package ch.bzz;

public class Book {
    private int id;
    private String isbn;
    private String title;
    private String author;
    private int year;


    public Book(int id, String isbn, String title, String author, int year) {
        this.id = id;
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.year = year;
    }


    public String toString() {
        return String.format("%s: %s by %s (%s) [ISBN: %s]", id, title, author, year, isbn);
    }

    public int getId() {
        return id;
    }


    public String getIsbn() {
        return isbn;
    }


    public String getTitle() {
        return title;

    }

    public String getAuthor() {
        return author;
    }

    public int getPublicationYear() {
        return year;
    }
}
