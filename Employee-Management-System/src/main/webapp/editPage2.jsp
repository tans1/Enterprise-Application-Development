<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Edit Employee</title>
    <link rel="stylesheet" href="css/bootstrap.css">
</head>
<body class="container-fluid card" style="width: 40rem;">
    <h2 class="bg-danger text-white text-center">Edit Employee</h2>
    <form action="saveedited" method="post">
        <table class="table table-hover">
        <tr>
                <td>Id</td>
                <td><input type="text" name="id" value="<c:out value='${id}' />" /></td>
            </tr>
            <tr>
                <td>Name</td>
                <td><input type="text" name="name" value="<c:out value='${name}' />" /></td>
            </tr>
            <tr>
                <td>Designation</td>
                <td><input type="text" name="designation" value="<c:out value='${designation}' />" /></td>
            </tr>
            <tr>
                <td>Salary</td>
                <td><input type="text" name="salary" value="<c:out value='${salary}' />" /></td>
            </tr>
            <tr>
                <td><input type="submit" value="Update"></td>
            </tr>
        </table>
    </form>
</body>
</html>
