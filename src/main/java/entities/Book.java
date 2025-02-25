package entities;
import java.util.List;
public class Book {
    private String title;
    private int releaseYear;
    private List<Author> authors;
    private int id;

    public Book(String title, int releaseYear, List<Author> authors, int id) {
        this.title = title;
        this.releaseYear = releaseYear;
        this.authors = authors;
        this.id = id;
    }

    public Book(String title, int releaseYear, List<Author> authors) {
        this.title = title;
        this.releaseYear = releaseYear;
        this.authors = authors;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }

    public List<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(List<Author> authors) {
        this.authors = authors;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", releaseYear=" + releaseYear +
                ", authors=" + authors +
                ", id=" + id +
                '}';
    }
}
