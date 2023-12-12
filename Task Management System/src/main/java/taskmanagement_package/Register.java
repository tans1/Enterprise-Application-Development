package taskmanagement_package;

import java.sql.Connection;
import java.sql.PreparedStatement;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/register")
public class Register extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response)  {
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		try {
			DbConfig db = new DbConfig();
			Connection conn = db.createConnection();
			
			String query = "insert into users(name, email, password) values(?,?,?)";
			PreparedStatement statement = conn.prepareStatement(query);
			statement.setString(1, name);
			statement.setString(2, email);
			statement.setString(3, password);
			statement.executeUpdate();
			conn.close();
			response.sendRedirect("loginpage.html");
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

}
