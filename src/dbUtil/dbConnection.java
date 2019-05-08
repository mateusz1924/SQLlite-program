package dbUtil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class dbConnection {
        private final static String USERNAME = "dbuser";
        private final static String PASSWORD = "dbpassword";
        private final static String CONN = "jdbc:mysql://localhost/login";
        private final static String SQCONN = "jdbc:sqlite:szkola0.sqlite";

        public static Connection getConnection() throws SQLException {

            try{
                Class.forName("org.sqlite.JDBC");
                return DriverManager.getConnection(SQCONN);
            }catch (ClassNotFoundException ex){
                ex.printStackTrace();
            }
        return null;
    }
}
