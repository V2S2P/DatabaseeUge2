package entities;

import java.util.List;

public class Borrower {
    private String name;
    private int id;
    private String address;
    private List<Loan> borrowedBooks;

    public Borrower(String name, int id, String address, List<Loan> borrowedBooks) {
        this.name = name;
        this.id = id;
        this.address = address;
        this.borrowedBooks = borrowedBooks;
    }

    public Borrower(String name, String address, List<Loan> borrowedBooks) {
        this.name = name;
        this.address = address;
        this.borrowedBooks = borrowedBooks;
    }
    public void addLoan(Loan loan){
        borrowedBooks.add(loan);
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<Loan> getBorrowedBooks() {
        return borrowedBooks;
    }

    public void setBorrowedBooks(List<Loan> borrowedBooks) {
        this.borrowedBooks = borrowedBooks;
    }

    @Override
    public String toString() {
        return "Borrower{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", address='" + address + '\'' +
                ", borrowedBooks=" + borrowedBooks +
                '}';
    }
}
