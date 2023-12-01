package calculator;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/multiplication")
public class MultiplicationHandler extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) {
		int num1 = Integer.parseInt(request.getParameter("num1"));
		int num2 = Integer.parseInt(request.getParameter("num2"));
		
		try {
			PrintWriter pw = response.getWriter();
			response.setContentType("text/html");
			pw.println(
					"<h3>"+ num1 + "</h3>" + 
					"  *  " + 
					"<h3>"+ num2 + "</h3>" + 
					"  =  " + 
					"<h3>" + (num1 * num2) + "</h3>"
					
			);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}






