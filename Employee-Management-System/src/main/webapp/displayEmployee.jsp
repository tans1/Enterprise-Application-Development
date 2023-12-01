<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Employee Data</title>
    <link rel="stylesheet" href="css/bootstrap.css">
</head>
<body class="container-fluid card" style="width: 40rem;">
    <h1 class="bg-danger text-white text-center">Employee Data</h1>
    <table class="table table-hover">
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Designation</th>
            <th>Salary</th>
        </tr>
        <c:forEach var="employee" items="${employeeList}">
            <tr>
                <td>${employee.id}</td>
                <td>${employee.name}</td>
                <td>${employee.designation}</td>
                <td>${employee.salary}</td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
