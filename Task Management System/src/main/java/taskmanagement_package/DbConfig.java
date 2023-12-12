package taskmanagement_package;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class DbConfig {
	private static final String DB_URL ="jdbc:mysql://localhost:3306/users";
	private static final String DB_USER = "root";
	private static final String DB_PASSWORD = "12345678";
	
	protected Connection createConnection() throws Exception {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
	        Statement statement = connection.createStatement();
            String createUsersTable = "CREATE TABLE IF NOT EXISTS users (" +
                    "id INT AUTO_INCREMENT PRIMARY KEY," +
                    "name VARCHAR(255) NOT NULL," +
                    "email VARCHAR(255) NOT NULL," +
                    "password VARCHAR(255) NOT NULL)";
            statement.executeUpdate(createUsersTable);
	        
            String createTasksTable = "CREATE TABLE IF NOT EXISTS tasks (" +
                    "id INT AUTO_INCREMENT PRIMARY KEY," +
                    "userId INT NOT NULL," +
                    "title VARCHAR(255) NOT NULL," +
                    "description VARCHAR(255) NOT NULL," +
                    "duedate VARCHAR(255) NOT NULL," +
                    "priority VARCHAR(255) NOT NULL," +
                    "completed BOOLEAN NOT NULL," +
                    "FOREIGN KEY (userId) REFERENCES users(id))";
            statement.executeUpdate(createTasksTable);
            return connection;
        } catch (Exception e) {
            e.printStackTrace();
            throw e; 
        }
    }
}
