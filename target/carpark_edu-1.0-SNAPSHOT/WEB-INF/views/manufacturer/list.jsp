<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Manufacturer List</title>
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
    <h1>Manufacturer List</h1>
    <a href="cars">View Cars</a>
    <a href="carparks">View Car Parks</a>
</div>

<table>
    <thead>
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Country</th>
        <th>Founded Year</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="manufacturer" items="${manufacturers}">
        <tr>
            <td>${manufacturer.id}</td>
            <td>${manufacturer.name}</td>
            <td>${manufacturer.country}</td>
            <td>${manufacturer.foundedYear}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>