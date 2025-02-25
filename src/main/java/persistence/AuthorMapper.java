package persistence;

import entities.Author;
import exceptions.DatabaseException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AuthorMapper {
    private DatabaseConnector databaseConnection;

    public AuthorMapper(DatabaseConnector databaseConnection){
        this.databaseConnection = databaseConnection;
    }
    public Author findAuthorById(int id) throws DatabaseException {
        String sql = "SELECT forfatter_id, navn FROM forfatter WHERE forfatter_id = ?";
        try (Connection connection = databaseConnection.getConnection()) {

            try (PreparedStatement prepareStatement = connection.prepareStatement(sql)) {
                prepareStatement.setInt(1, id);
                ResultSet resultSet = prepareStatement.executeQuery();

                if (resultSet.next()) {
                    int authorId = resultSet.getInt("forfatter_id");
                    String name = resultSet.getString("navn");
                    return new Author(name,authorId,null);
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
