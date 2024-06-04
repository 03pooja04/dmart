package ConnectionHelper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public final class ConnectionHelper {
    private static final String url = "jdbc:mysql://localhost:3306/database";
    private static final String userName = "root";
    private static final String password = "pooja123";

    public ConnectionHelper() {
    }

    public static Connection getConnection() {
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/database", "root", "pooja123");
            return connection;
        } catch (SQLException var2) {
            throw new RuntimeException(var2);
        }
    }
}
