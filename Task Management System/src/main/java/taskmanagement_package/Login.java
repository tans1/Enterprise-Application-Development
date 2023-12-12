package taskmanagement_package;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/login")
public class Login extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) {
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		try {
			DbConfig db = new DbConfig();
			Connection conn = db.createConnection();
			String query = "select * from users where email = ? AND password = ?";
			PreparedStatement statement = conn.prepareStatement(query);
			statement.setString(1, email);
			statement.setString(2, password);
			ResultSet rs = statement.executeQuery();
			
			if(rs.next()) {				
				int userId = rs.getInt("id");
				HttpSession session = request.getSession();
				session.setAttribute("userId", userId);
				
				TaskCRUD tasks = new TaskCRUD();
				List<TaskEntity> userTasksList = tasks.GetAllTasks(userId);
				
			    request.setAttribute("taskList", userTasksList);
			    RequestDispatcher dispatcher = request.getRequestDispatcher("home.jsp");
	            dispatcher.forward(request, response);

			}else {
				response.sendRedirect("loginpage.html");
			}
			conn.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

}
