package storage.database.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import util.SettingsLoader;

public class DatabaseConnection {

    private final Connection connection;
    private static DatabaseConnection instance;

    private DatabaseConnection() throws SQLException {
        System.out.println("Connecting to database server...\n");
        String url = SettingsLoader.getInstance().getProperty("url");
        String dbuser = SettingsLoader.getInstance().getProperty("user");
        String dbpassword = SettingsLoader.getInstance().getProperty("password");
        connection = DriverManager.getConnection(url, dbuser, dbpassword);
        connection.setAutoCommit(false);
        System.out.println("Successful connection to the database!");
        System.out.println("==========================================================================\n");
    }

    public static DatabaseConnection getInstance() throws SQLException {
        if (instance == null) {
            instance = new DatabaseConnection();
        }
        return instance;
    }

    public Connection getConnection() {
        return connection;
    }

    public void commit() throws SQLException {
        connection.commit();
    }

    public void rollback() throws SQLException {
        connection.rollback();
    }

}
