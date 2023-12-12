package online_registration_package;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConfig {
	private static final String DB_URL ="jdbc:mysql://localhost:3306/users";
	private static final String DB_USER = "root";
	private static final String DB_PASSWORD = "12345678";
	
	protected Connection createConnection() throws Exception {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
        } catch (Exception e) {
            e.printStackTrace();
            throw e; 
        }
    }
}
