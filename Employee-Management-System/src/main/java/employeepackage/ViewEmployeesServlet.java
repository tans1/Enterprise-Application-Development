package employeepackage;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/view")
public class ViewEmployeesServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
        DbConfig dbConfig = new DbConfig();
        List<Employee> employeeList = new ArrayList<>();

        try {
            Class.forName(dbConfig.driver);
            Connection connection = DriverManager.getConnection(dbConfig.url, dbConfig.username, dbConfig.password);
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery("SELECT * FROM employees");

            while (result.next()) {
                int id = result.getInt("id");
                String name = result.getString("name");
                String designation = result.getString("designation");
                int salary = result.getInt("salary");

                Employee employee = new Employee(id, name, designation, salary);
                employeeList.add(employee);
            }

            result.close();
            statement.close();
            connection.close();

            request.setAttribute("employeeList", employeeList);
            RequestDispatcher dispatcher = request.getRequestDispatcher("displayEmployee.jsp");
            dispatcher.forward(request, response);

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error occurred while displaying the employee");
        }
    }
}
