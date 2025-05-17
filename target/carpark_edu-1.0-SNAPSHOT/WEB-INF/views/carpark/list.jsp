<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Car Park List</title>
    <style>
        table { width: 100%; border-collapse: collapse; margin-top: 20px; }
        th, td { padding: 12px; text-align: left; border-bottom: 1px solid #ddd; }
        th { background-color: #f2f2f2; }
        tr:hover { background-color: #f5f5f5; }
        .header { display: flex; justify-content: space-between; align-items: center; }
    </style>
</head>
<body>
<div class="header">
    <h1>Car Park List</h1>
    <a href="cars">View Cars</a>
    <a href="manufacturers">View Manufacturers</a>
</div>

<table>
    <thead>
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Address</th>
        <th>Capacity</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="carpark" items="${carParks}">
        <tr>
            <td>${carpark.id}</td>
            <td>${carpark.name}</td>
            <td>${carpark.address}</td>
            <td>${carpark.capacity}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>