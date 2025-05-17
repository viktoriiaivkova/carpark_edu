<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Car List</title>
    <style>
        table { width: 100%; border-collapse: collapse; margin-top: 20px; }
        th, td { padding: 12px; text-align: left; border-bottom: 1px solid #ddd; }
        th { background-color: #f2f2f2; }
        tr:hover { background-color: #f5f5f5; }
        .action-btns a { margin-right: 10px; text-decoration: none; }
        .btn { padding: 8px 12px; border-radius: 4px; }
        .btn-primary { background-color: #007bff; color: white; }
        .btn-success { background-color: #28a745; color: white; }
        .btn-danger { background-color: #dc3545; color: white; }
        .btn-info { background-color: #17a2b8; color: white; }
        .header { display: flex; justify-content: space-between; align-items: center; }
    </style>
</head>
<body>
<div class="header">
    <h1>Car List</h1>
    <div>
        <a href="manufacturers">View Manufacturers</a>
        <a href="carparks">View Car Parks</a>
        <a href="cars?action=new" class="btn btn-primary">Add New Car</a>
    </div>
</div>

<table>
    <thead>
    <tr>
        <th>ID</th>
        <th>License Plate</th>
        <th>Model</th>
        <th>Color</th>
        <th>Manufacturer</th>
        <th>Car Park</th>
        <th>Actions</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="car" items="${cars}">
        <tr>
            <td>${car.id}</td>
            <td>${car.licensePlate}</td>
            <td>${car.model}</td>
            <td>${car.color}</td>
            <td>${car.manufacturer.name} (ID: ${car.manufacturer.id})</td>
            <td>${car.carPark.name} (ID: ${car.carPark.id})</td>
            <td class="action-btns">
                <a href="cars?action=view&id=${car.id}" class="btn btn-info">View</a>
                <a href="cars?action=edit&id=${car.id}" class="btn btn-success">Edit</a>
                <a href="cars?action=delete&id=${car.id}"
                   onclick="return confirm('Are you sure you want to delete this car?')"
                   class="btn btn-danger">Delete</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>