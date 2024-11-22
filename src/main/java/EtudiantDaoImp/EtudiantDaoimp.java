package EtudiantDaoImp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import DatabaseManager.databaseManager;
import EtudiantDao.EtudiantDao;
import Models.Etudiant;

public class EtudiantDaoimp implements EtudiantDao {

    @Override
    public boolean saveStudent(Etudiant e) {
        databaseManager db = new databaseManager();
        String query = "INSERT INTO client (nom, prenom, cne, email) VALUES (?, ?, ?, ?)";

        try (Connection connection = db.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            // Set the parameters
            preparedStatement.setString(1, e.getNom());
            preparedStatement.setString(2, e.getPrenom());
            preparedStatement.setString(3, e.getCne());
            preparedStatement.setString(4, e.getEmail());

            // Execute the query
            int rowsInserted = preparedStatement.executeUpdate();
            return rowsInserted > 0; // Return true if the student was saved successfully
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false; // Return false if an exception occurs
        }
    }

    @Override
    public List<Etudiant> SelectAll() {
        databaseManager db = new databaseManager();
        String query = "SELECT * FROM client";

        List<Etudiant> students = new ArrayList<>();
        try (Connection connection = db.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            // Process the ResultSet
            while (resultSet.next()) {
                Etudiant etudiant = new Etudiant(resultSet.getString("nom"),resultSet.getString("prenom"),resultSet.getString("cne"),resultSet.getString("email"));
                students.add(etudiant);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return students;
    }
}
