package employeepackage;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

@WebServlet("/saveedited")
public class AddEditedEmployee extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) {
        DbConfig dbConfig = new DbConfig();
        try {
            Class.forName(dbConfig.driver);
            Connection connection = DriverManager.getConnection(dbConfig.url, dbConfig.username, dbConfig.password);
            Statement statement = connection.createStatement();

            int id = Integer.parseInt(request.getParameter("id"));
            String name = request.getParameter("name");
            String designation = request.getParameter("designation");
            int salary = Integer.parseInt(request.getParameter("salary"));

            String updateStatement = String.format("UPDATE employees SET name = '%s', designation = '%s', salary = %d WHERE id = %d", name, designation, salary, id);

            statement.executeUpdate(updateStatement);

            statement.close();
            connection.close();

            response.sendRedirect("successPage.html");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
