package online_registration_package;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	protected void doPost(HttpServletRequest rq, HttpServletResponse rp){
		String email = rq.getParameter("email");
		String password = rq.getParameter("password");
		
		try {
			DatabaseConfig db = new DatabaseConfig();
			Connection conn = db.createConnection();
			
			String query = "select * from users where email = ? AND password = ?";
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setString(1, email);
			pstmt.setString(2, password);
			ResultSet rs = pstmt.executeQuery();
			
			if(rs.next()) {
				
				HttpSession session = rq.getSession();
				session.setAttribute("email", email);
				
				rp.sendRedirect("welcome.jsp");
			}else {
				rp.sendRedirect("login.jsp");
			}
			conn.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}