package persistence;

import entities.Author;
import entities.Book;
import exceptions.DatabaseException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BookMapper {
    private DatabaseConnector databaseConnection;

    public BookMapper(DatabaseConnector databaseConnection){
        this.databaseConnection = databaseConnection;
    }
    public Book findBookById(int id) throws DatabaseException {
        String sql = "SELECT bog_id, titel, udgivelsesar, forfatter_id FROM bog WHERE bog_id = ?";
        try (Connection connection = databaseConnection.getConnection()) {

            try (PreparedStatement prepareStatement = connection.prepareStatement(sql)) {
                prepareStatement.setInt(1, id);
                ResultSet resultSet = prepareStatement.executeQuery();

                if (resultSet.next()) {
                    String title = resultSet.getString("titel");
                    int releaseYear = resultSet.getInt("udgivelsesar");
                    int authorId = resultSet.getInt("forfatter_id");
                    return new Book(title,releaseYear,null,authorId);
                } else {
                    return null;
                }
            }
        }
        catch (SQLException e) {
            throw new DatabaseException("Could not get borrowers from the database", e);
        }
    }
}
