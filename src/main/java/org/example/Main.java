package org.example;

import entities.Author;
import entities.Borrower;
import exceptions.DatabaseException;
import persistence.AuthorMapper;
import persistence.BorrowerMapper;
import persistence.DatabaseConnector;

public class Main {
    private static final String USERNAME = "postgres";
    private static final String PASSWORD = "postgres";
    private static final String URL = "jdbc:postgresql://localhost:5432/FredagsOpgaveDBUge1?currentSchema=public";
    private static DatabaseConnector databaseConnector;

    static {
        try {
            databaseConnector = new DatabaseConnector(USERNAME, PASSWORD, URL);
        }
        catch (DatabaseException e) {
            System.out.println(e.getMessage());

        }
    }

    public static void main(String[] args) {

        BorrowerMapper borrowerMapper = new BorrowerMapper(databaseConnector);
        AuthorMapper authorMapper = new AuthorMapper(databaseConnector);
        try {
            Borrower borrower = borrowerMapper.findBorrowerById(1);
            Author author = authorMapper.findAuthorById(1);
            System.out.println(borrower);
            System.out.println(author);
        }
        catch (DatabaseException e) {
            System.out.println(e.getMessage());
            System.out.println(e.getCause().getMessage());
        }
    }
}
