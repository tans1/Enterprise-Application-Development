package taskmanagement_package;

import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/tasks")
public class TaskServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        int userId = (int) session.getAttribute("userId");
        String taskId = request.getParameter("id");
        String title = request.getParameter("title");
        String description = request.getParameter("description");
        String duedate = request.getParameter("duedate");
        String priority = request.getParameter("priority");
        Boolean completed;
        try {
            TaskCRUD tasks = new TaskCRUD();
            if (taskId != null) {
            	int id = Integer.parseInt(taskId);
            	if (request.getParameter("completed") != null) {
            		completed = true;
            	} else {
            		completed = false;
            	}
            	tasks.UpdateTask(id, title, description, duedate, priority, completed);
            }
            else {
            	tasks.CreateTask(userId, title, description, duedate, priority);
            }
            
            
    		List<TaskEntity> userTasksList = tasks.GetAllTasks(userId);
  
    	    request.setAttribute("taskList", userTasksList);
    	    RequestDispatcher dispatcher = request.getRequestDispatcher("home.jsp");
            dispatcher.forward(request, response);
        }
        catch (Exception e) {
        	e.printStackTrace();
        }
        
	} 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) {
		TaskCRUD tasks = new TaskCRUD();
		
		HttpSession session = request.getSession();
        int userId = (int) session.getAttribute("userId");
        
        String title = request.getParameter("search");
        String taskIdParam = request.getParameter("id");
        
		try {
	        if (taskIdParam != null) {
                // Get task by ID
	        	
	        	int taskId = Integer.parseInt(taskIdParam);
	        	TaskEntity task = tasks.GetTaskById(userId, taskId);
	        	request.setAttribute("task", task);
	        	
			    RequestDispatcher dispatcher = request.getRequestDispatcher("edit.jsp");
		        dispatcher.forward(request, response);
                
            } else if (title != null) {
                // Get tasks by title
            	
            	List<TaskEntity> userTasksList = tasks.GetTasksByTitle(userId, title);
            	request.setAttribute("taskList", userTasksList);
            	
    		    RequestDispatcher dispatcher = request.getRequestDispatcher("home.jsp");
    	        dispatcher.forward(request, response);
            }
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) {		
        HttpSession session = request.getSession();
        int userId = (int) session.getAttribute("userId");
        String taskId = request.getParameter("id");
        try {
            TaskCRUD tasks = new TaskCRUD();
            tasks.DeleteTask(Integer.parseInt(taskId));
            
    		List<TaskEntity> userTasksList = tasks.GetAllTasks(userId);
  
    	    request.setAttribute("taskList", userTasksList);
    	    RequestDispatcher dispatcher = request.getRequestDispatcher("home.jsp");
            dispatcher.forward(request, response);
        }
        catch (Exception e) {
        	e.printStackTrace();
        }
	}
	
	
	
	
	
}
