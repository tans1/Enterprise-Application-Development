<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Create Task</title>
	<link rel="stylesheet" href="css/bootstrap.css">
</head>
<body>
<div class="container mt-5">
  <h1 class="mb-4">Create Task</h1>
  <form action="tasks" method="post">
    <div class="form-group">
      <label for="title">Title:</label>
      <input type="text" class="form-control" id="title" name="title" required>
    </div>
    <div class="form-group">
      <label for="description">Description:</label>
      <textarea class="form-control" id="description" name="description" rows="3" required></textarea>
    </div>
    <div class="form-group">
      <label for="duedate">Due Date:</label>
      <input type="date" class="form-control" id="duedate" name="duedate" required>
    </div>
    <div class="form-group">
	    <label for="priority">Priority:</label>
	      <select class="form-control" id="priority" name="priority" required>
	        <option value="High">High</option>
	        <option value="Medium">Medium</option>
	        <option value="Low">Low</option>
	      </select>
	    </div>
	    <button type="submit" class="btn btn-success">Create Task</button>
	  </form>
	</div>
</body>
</html>