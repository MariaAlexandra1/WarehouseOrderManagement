package Connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Clasa ConnectionFactory este responsabilă pentru gestionarea conexiunilor la baza de date.
 * Aceasta folosește un model Singleton pentru a asigura o unică instanță de conexiune.
 * Include metode pentru crearea și închiderea conexiunilor, a statement-urilor și a result set-urilor.
 *
 * @author Maria-Alexandra Buzila, 30226
 * @since May 2024
 */
public class ConnectionFactory {

    private static final Logger LOGGER = Logger.getLogger(ConnectionFactory.class.getName());
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String DBURL = "jdbc:mysql://localhost:3306/warehouse";
    private static final String USER = "root";
    private static final String PASS = "AlleDB2003";

    private static ConnectionFactory singleInstance = new ConnectionFactory();

    /**
     * Constructorul privat al clasei ConnectionFactory.
     * Încarcă driverul necesar pentru conexiunea la baza de date.
     */
    private ConnectionFactory() {
        try {
            Class.forName(DRIVER);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * Creează o nouă conexiune la baza de date.
     *
     * @return Conexiunea creată sau null dacă apare o eroare.
     */
    private Connection createConnection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(DBURL, USER, PASS);
        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, "An error occured while trying to connect to the database");
            e.printStackTrace();
        }
        return connection;
    }

    /**
     * Returnează o conexiune la baza de date folosind instanța singleton.
     *
     * @return Conexiunea la baza de date.
     */
    public static Connection getConnection() {
        return singleInstance.createConnection();
    }

    /**
     * Închide o conexiune la baza de date.
     *
     * @param connection Conexiunea de închis.
     */
    public static void close(Connection connection) {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                LOGGER.log(Level.WARNING, "An error occured while trying to close the connection");
            }
        }
    }

    /**
     * Închide un statement.
     *
     * @param statement Statement-ul de închis.
     */
    public static void close(Statement statement) {
        if (statement != null) {
            try {
                statement.close();
            } catch (SQLException e) {
                LOGGER.log(Level.WARNING, "An error occured while trying to close the statement");
            }
        }
    }

    /**
     * Închide un result set.
     *
     * @param resultSet ResultSet-ul de închis.
     */
    public static void close(ResultSet resultSet) {
        if (resultSet != null) {
            try {
                resultSet.close();
            } catch (SQLException e) {
                LOGGER.log(Level.WARNING, "An error occured while trying to close the ResultSet");
            }
        }
    }
}
