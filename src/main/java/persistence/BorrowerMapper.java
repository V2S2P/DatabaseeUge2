package persistence;
import entities.Borrower;
import exceptions.DatabaseException;

import java.sql.*;
public class BorrowerMapper {
    private DatabaseConnector dataBaseConnection;

    public BorrowerMapper(DatabaseConnector dataBaseConnectiong) {
        this.dataBaseConnection = dataBaseConnectiong;
    }

    public Borrower findBorrowerById(int id) throws DatabaseException {
        String sql = "SELECT navn, adresse, postnr FROM laaner WHERE laaner_id = ?";
        try (Connection connection = dataBaseConnection.getConnection()) {

            try (PreparedStatement prepareStatement = connection.prepareStatement(sql)) {
                prepareStatement.setInt(1, id);
                ResultSet resultSet = prepareStatement.executeQuery();

                if (resultSet.next()) {
                    String name = resultSet.getString("navn");
                    String address = resultSet.getString("adresse");
                    int zip = resultSet.getInt("postnr");
                    return new Borrower(name,id,address + " " + zip,null);
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
