<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Edit page</title>
	<link rel="stylesheet" href="css/bootstrap.css">
</head>
<body>
	<script>
        const deleteTask = (taskId) => {
        	fetch('http://localhost:8082/Task_Management_System/tasks?id='+taskId, {
                method: "DELETE"
            })
            .then(response => {
                if (!response.ok) {
                    throw new Error(`HTTP error! Status: ${response.status}`);
                }
                console.log("Task deleted successfully");
            })
            .catch(error => {
                console.error("Error deleting task:", error);
            });
        }
    </script>
	<div class="container mt-5">
	
	     <h1 class="mb-4">Edit Task</h1>
	     <form method="post" action="tasks">
	         <input type="hidden" name="id" value="${task.id}">
	         <div class="form-group">
	             <label for="title">Title:</label>
	             <input type="text" class="form-control" id="title" name="title" value="${task.title}" required>
	         </div>
	         
	         <div class="form-group">
	             <label for="description">Description:</label>
	             <textarea class="form-control" id="description" name="description" rows="3" required>${task.description}</textarea>
	         </div>
	         
	         <div class="form-group">
	             <label for="duedate">Due Date:</label>
	             <input type="text" class="form-control" id="duedate" name="duedate" value="${task.duedate}" required>
	         </div>
	         
	         <div class="form-group">
	             <label for="priority">Priority:</label>
	             <select class="form-control" id="priority" name="priority" required>
	                 <option value="High">High</option>
	                 <option value="Medium">Medium</option>
	                 <option value="Low">Low</option>
	             </select>
	         </div>
	         
	         <div class="form-check">
	             <input type="checkbox" class="form-check-input" id="completed" name="completed" ${task.completed ? "checked" : ""} >
	             <label class="form-check-label" for="completed">Completed</label>
	         </div>
	         
	         <button type="submit" class="btn btn-primary mt-3">Save Changes</button>
	         
	         <button class="btn btn-warning mt-3 ml-5" onclick=deleteTask(${task.id})>Delete Task</button>

	     </form>
	 </div>
</body>
</html>
	
	
	
	
	
	
	
	
	
	
	
	
