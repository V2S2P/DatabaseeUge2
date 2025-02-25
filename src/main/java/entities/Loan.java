package entities;
import java.time.LocalDate;
public class Loan {
    private Book book;
    private LocalDate date;
    private int id;

    public Loan(Book book, LocalDate date, int id) {
        this.book = book;
        this.date = date;
        this.id = id;
    }

    public Loan(Book book, LocalDate date) {
        this.book = book;
        this.date = date;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
