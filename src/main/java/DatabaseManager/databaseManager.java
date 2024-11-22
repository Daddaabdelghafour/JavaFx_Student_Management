package DatabaseManager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class databaseManager {

    private static final String URL = "jdbc:mysql://localhost:3306/jfx"; // Replace with your database URL
    private static final String USER = "root"; // Replace with your database username
    private static final String PASSWORD = ""; // Replace with your database password

    /**
     * Establishes a connection to the database.
     * @return Connection object
     * @throws SQLException if a database access error occurs
     */
    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    /**
     * Creates a Statement object for executing SQL queries.
     * @return Statement object
     * @throws SQLException if a database access error occurs
     */
    public Statement getStatement() throws SQLException {
        Connection connection = getConnection(); // Get connection
        return connection.createStatement(); // Create and return the Statement
    }
}
