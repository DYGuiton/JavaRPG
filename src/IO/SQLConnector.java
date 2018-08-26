package IO;

/**
 * @author Yurichi
 */
import java.sql.*;

public class SQLConnector {

    Connection theConnection;

    public SQLConnector() throws Exception {
        theConnection = getConnection();
    }

    protected Connection getConnection() throws Exception {
        Connection conn = null;
        String url = "jdbc:mysql://localhost:3306/rpgdatabase";
        String username = "root";
        String password = "Akichid#3";
        try {

            conn = DriverManager.getConnection(url, username, password);
            if (conn != null) {
                System.out.println("Connection Successful.");
                return conn;
            }
        } catch (Exception e) {
            System.out.println("Connection Unsuccessful.");
        }

        return null;
    }

    protected ResultSet getTable(String tableName) throws Exception {

        PreparedStatement statement = theConnection.prepareStatement("SELECT * FROM " + tableName);

        ResultSet result = statement.executeQuery();

        return result;

    }
}
