package calculator;


import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/home")
public class Home extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response ) {
		String operator = request.getParameter("operation");
		switch (operator) {
		case "+":
			RequestDispatcher additionDispatcher = request.getRequestDispatcher("/addition");
			try {
				additionDispatcher.forward(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			} 
			break;
		case "*":
			RequestDispatcher multiplicationDispatcher = request.getRequestDispatcher("/multiplication");
			try {
				multiplicationDispatcher.forward(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			} 
			break;
		default:
			System.out.println("Choose appropriate operator");
		}
	}
}



