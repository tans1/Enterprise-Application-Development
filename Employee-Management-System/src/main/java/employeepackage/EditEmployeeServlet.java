package employeepackage;

import jakarta.servlet.RequestDispatcher;
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

@WebServlet("/edit")
public class EditEmployeeServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)  {
		DbConfig dbConfig = new DbConfig();
		try {
			Class.forName(dbConfig.driver);
			Connection connection = DriverManager.getConnection(dbConfig.url, dbConfig.username, dbConfig.password);
	        Statement statement = connection.createStatement();
	        
	        int id = Integer.parseInt(request.getParameter("id"));
	        String getQuery = String.format("SELECT * FROM employees WHERE id = %d", id);
	        
	        ResultSet result = statement.executeQuery(getQuery);
	        
	        if (result.next()) {
	        	request.setAttribute("id", result.getInt("id"));
	            request.setAttribute("name", result.getString("name"));
	            request.setAttribute("designation", result.getString("designation"));
	            request.setAttribute("salary", result.getInt("salary"));

	            RequestDispatcher dispatcher = request.getRequestDispatcher("editPage2.jsp");
	            dispatcher.forward(request, response);
	        } else {
	            response.getWriter().println("No employee found with ID " + id);
	        }
		} catch (Exception e) {
			e.printStackTrace();
		}
        
		
	}

}
