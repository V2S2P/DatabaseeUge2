package entities;

import java.util.List;

public class Author {
    private String name;
    private int id;
    private List<Book> books;

    public Author(String name, int id, List<Book> books) {
        this.name = name;
        this.id = id;
        this.books = books;
    }

    public Author(String name, List<Book> books) {
        this.name = name;
        this.books = books;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }
    public void addBook(Book book){
        books.add(book);
    }

    @Override
    public String toString() {
        return "Author{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", books=" + books +
                '}';
    }
}
