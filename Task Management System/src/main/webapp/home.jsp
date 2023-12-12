<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List" %>
<%@ page import="taskmanagement_package.TaskEntity" %>
<%@ page import="java.util.Iterator" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Task management</title>
	<link rel="stylesheet" href="css/bootstrap.css">
	<style>
	    .row-datas { cursor: pointer; }
	    .row-datas:hover { background-color: #e0e0e0; }
	</style>	
</head>
<body>
<script>
	</script>
	<div class="container mt-5">
	  <h1 class="mb-4">Task Management</h1>
	  <div class="row">
	    <div class="col-9">
	      <form action="tasks" method="get" class="mb-3">
	        <div class="input-group">
	          <input type="text" class="form-control" id="search" name="search" placeholder="Search" aria-label="Search" aria-describedby="searchButton">
	          <div class="input-group-append">
	            <button type="submit" class="btn btn-primary" id="searchButton">Search</button>
	          </div>
	        </div>
	      </form>
	    </div>
	    <div class="col-3">
	    	<a href="create.jsp" class="btn btn-success">Create New Task</a>
	    </div>
	  </div>
	</div>
	<div class="container mt-5">
	  <table class="table table-bordered table-striped">
	    <thead>
	      <tr >
	        <th scope="col" class="col-1">ID</th>
	        <th scope="col" class="col-2">Title</th>
	        <th scope="col" class="col-4">Description</th>
	        <th scope="col" class="col-2">Due Date</th>
	        <th scope="col" class="col-1">Priority</th>
	        <th scope="col" class="col-1">Completed</th>
	      </tr>
	    </thead>
	    <tbody>
    		<%
				  List<TaskEntity> taskList = (List<TaskEntity>) request.getAttribute("taskList");
				  if (taskList != null) {
				    for (TaskEntity task : taskList) {
				%>
				      <form method="get" action="tasks" class=form-to-edit-<%= task.getId() %> >
				        <input type="hidden" name="id" value="<%= task.getId() %>">
				        <tr class="row-datas" onclick="document.querySelector('.form-to-edit-<%= task.getId() %>').submit()">
				          <th scope="row"><%= task.getId() %></th>
				          <td><%= task.getTitle() %></td>
				          <td><%= task.getDescription() %></td>
				          <td><%= task.getDuedate() %></td>
				          <td><%= task.getPriority() %></td>
				          <td><%= task.getCompleted() %></td> 
				        </tr>
				      </form>
				<% } } %>

	    </tbody>
	  </table>
	</div>
	
</body>
</html>
