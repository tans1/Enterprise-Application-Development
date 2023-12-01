package employeepackage;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

@WebServlet("/delete")
public class DeleteEmployeeServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response){	
		DbConfig dbConfig = new DbConfig();
		
		try {
			Class.forName(dbConfig.driver);
			Connection connection = DriverManager.getConnection(dbConfig.url, dbConfig.username, dbConfig.password);
	        Statement statement = connection.createStatement();
	        int id = Integer.parseInt(request.getParameter("id"));

	        String deleteQuery = String.format("DELETE FROM employees WHERE id = %d", id);
	        
	        statement.executeUpdate(deleteQuery);
	        statement.close();
	        connection.close();
	        
	        response.sendRedirect("successPage.html");
	        
		} catch (Exception e) {
			e.printStackTrace();
		}
        
		
	}

	
}
