package taskmanagement_package;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class TaskCRUD {
	protected List<TaskEntity> GetAllTasks(int userId) throws Exception {
		try {
			DbConfig db = new DbConfig();
			Connection conn = db.createConnection();
			
            List<TaskEntity> userTasksList = new ArrayList<>();
			String tasksQuery = "SELECT * FROM tasks WHERE userId = ?";
		    PreparedStatement statement = conn.prepareStatement(tasksQuery);
		    
		    statement.setInt(1, userId);
		    ResultSet tasksResultSet = statement.executeQuery();
		    
		    while (tasksResultSet.next()) {
		        int id  = tasksResultSet.getInt("id");
		        String title = tasksResultSet.getString("title");
		        String description = tasksResultSet.getString("description");
		        String duedate = tasksResultSet.getString("duedate");
		        String priority = tasksResultSet.getString("priority");
		        boolean completed = tasksResultSet.getBoolean("completed");
		        
		        TaskEntity userTask = new TaskEntity(id, title, description, duedate,priority, completed);
		        userTasksList.add(userTask);
		    }
		    
		   conn.close();
		   return userTasksList;
		}
		catch (Exception e) {
			throw e;
		}
	}

	
	
	protected void CreateTask(int userId,String title, String description, String duedate,String priority)  {
		try {
			DbConfig db = new DbConfig();
			Connection conn = db.createConnection();
	        boolean completed = false;
	        String insertQuery = "INSERT INTO tasks (userId, title, description,duedate,priority,completed) VALUES (?, ?,?,?,?,?)";
	        PreparedStatement statement = conn.prepareStatement(insertQuery);
	        
            statement.setInt(1, userId);
            statement.setString(2, title);
            statement.setString(3, description);
            statement.setString(4, duedate);
            statement.setString(5, priority);
            statement.setBoolean(6, completed);
            statement.executeUpdate();
	        conn.close();

		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

    protected void UpdateTask(int taskId, String title, String description, String duedate, String priority, boolean completed) {
        try {
            DbConfig db = new DbConfig();
            Connection conn = db.createConnection();
            String updateQuery = "UPDATE tasks SET title=?, description=?, duedate=?, priority=? , completed=? WHERE id=?";
            PreparedStatement statement = conn.prepareStatement(updateQuery);
            
            statement.setString(1, title);
            statement.setString(2, description);
            statement.setString(3, duedate);
            statement.setString(4, priority);
            statement.setBoolean(5, completed);
            statement.setInt(6, taskId);
            
            statement.executeUpdate();
            
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void DeleteTask(int taskId) {
        try {
            DbConfig db = new DbConfig();
            Connection conn = db.createConnection();
            String deleteQuery = "DELETE FROM tasks WHERE id=?";
            PreparedStatement statement = conn.prepareStatement(deleteQuery);
            
            statement.setInt(1, taskId);
            statement.executeUpdate();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected List<TaskEntity> GetTasksByTitle(int userId, String title) throws Exception {
        try {
            DbConfig db = new DbConfig();
            Connection conn = db.createConnection();
            List<TaskEntity> userTasksList = new ArrayList<>();
            String tasksQuery = "SELECT * FROM tasks WHERE userId = ? AND title LIKE ?";
            PreparedStatement statement = conn.prepareStatement(tasksQuery);
            
            statement.setInt(1, userId);
            statement.setString(2, "%" + title + "%");
            ResultSet tasksResultSet = statement.executeQuery();
            
            while (tasksResultSet.next()) {
                int id = tasksResultSet.getInt("id");
                String taskTitle = tasksResultSet.getString("title");
                String description = tasksResultSet.getString("description");
                String dueDate = tasksResultSet.getString("duedate");
                String priority = tasksResultSet.getString("priority");
                boolean completed = tasksResultSet.getBoolean("completed");
                
                TaskEntity userTask = new TaskEntity(id, taskTitle, description, dueDate, priority, completed);
                userTasksList.add(userTask);
            }
            
            conn.close();
            return userTasksList;
        } catch (Exception e) {
            throw e;
        }
    }
    
    protected TaskEntity GetTaskById(int userId, int taskId) throws Exception {
        try {
            DbConfig db = new DbConfig();
            Connection conn = db.createConnection();

            String taskQuery = "SELECT * FROM tasks WHERE userId = ? AND id = ?";
            PreparedStatement statement = conn.prepareStatement(taskQuery);
            statement.setInt(1, userId);
            statement.setInt(2, taskId);
            ResultSet taskResultSet = statement.executeQuery();

            if (taskResultSet.next()) {
                int id = taskResultSet.getInt("id");
                String title = taskResultSet.getString("title");
                String description = taskResultSet.getString("description");
                String dueDate = taskResultSet.getString("duedate");
                String priority = taskResultSet.getString("priority");
                boolean completed = taskResultSet.getBoolean("completed");

                TaskEntity userTask = new TaskEntity(id, title, description, dueDate, priority, completed);

                conn.close();
                return userTask;
            } else {
                conn.close();
                return null;
            }
        } catch (Exception e) {
            throw e;
        }
    }

}


