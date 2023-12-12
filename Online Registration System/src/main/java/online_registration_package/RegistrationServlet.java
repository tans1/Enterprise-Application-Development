package online_registration_package;

import java.sql.Connection;
import java.sql.PreparedStatement;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/register")
public class RegistrationServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest rq, HttpServletResponse rp){
		String name = rq.getParameter("name");
		String email = rq.getParameter("email");
		String password = rq.getParameter("password");
		
		try {
			DatabaseConfig db = new DatabaseConfig();
			Connection conn = db.createConnection();
			
			String query = "insert into users(name, email, password) values(?,?,?)";
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setString(1, name);
			pstmt.setString(2, email);
			pstmt.setString(3, password);
			pstmt.executeUpdate();
			conn.close();
			rp.sendRedirect("confirmation.jsp");
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}
