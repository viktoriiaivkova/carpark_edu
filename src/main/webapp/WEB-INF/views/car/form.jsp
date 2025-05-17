<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title><c:choose>
        <c:when test="${mode == 'create'}">Add New Car</c:when>
        <c:when test="${mode == 'view'}">View Car Details</c:when>
        <c:otherwise>Edit Car</c:otherwise>
    </c:choose></title>
    <style>
        .form-container { max-width: 600px; margin: 20px auto; padding: 20px; border: 1px solid #ddd; border-radius: 5px; }
        .form-group { margin-bottom: 15px; }
        label { display: block; margin-bottom: 5px; font-weight: bold; }
        input[type="text"], select { width: 100%; padding: 8px; border: 1px solid #ddd; border-radius: 4px; }
        .btn { padding: 8px 12px; border-radius: 4px; text-decoration: none; }
        .btn-primary { background-color: #007bff; color: white; border: none; }
        .btn-secondary { background-color: #6c757d; color: white; border: none; }
        .readonly-info { background-color: #f8f9fa; padding: 10px; border-radius: 4px; margin-bottom: 15px; }
    </style>
</head>
<body>
<div class="form-container">
    <h1><c:choose>
        <c:when test="${mode == 'create'}">Add New Car</c:when>
        <c:when test="${mode == 'view'}">Car Details</c:when>
        <c:otherwise>Edit Car</c:otherwise>
    </c:choose></h1>

    <c:if test="${mode != 'create'}">
        <div class="readonly-info">
            <strong>ID:</strong> ${car.id}
        </div>
    </c:if>

    <form action="cars" method="post">
        <input type="hidden" name="action" value="${mode == 'edit' ? 'update' : 'create'}" />
        <c:if test="${mode != 'create'}">
            <input type="hidden" name="id" value="${car.id}" />
        </c:if>

        <div class="form-group">
            <label for="licensePlate">License Plate:</label>
            <input type="text" id="licensePlate" name="licensePlate"
                   value="${car.licensePlate}" ${mode == 'view' ? 'readonly' : ''} required />
        </div>

        <div class="form-group">
            <label for="model">Model:</label>
            <input type="text" id="model" name="model"
                   value="${car.model}" ${mode == 'view' ? 'readonly' : ''} required />
        </div>

        <div class="form-group">
            <label for="color">Color:</label>
            <input type="text" id="color" name="color"
                   value="${car.color}" ${mode == 'view' ? 'readonly' : ''} />
        </div>

        <div class="form-group">
            <label for="manufacturerId">Manufacturer:</label>
            <c:choose>
                <c:when test="${mode == 'view'}">
                    <input type="text" readonly value="${car.manufacturer.name} (ID: ${car.manufacturer.id})" />
                    <div style="margin-top: 10px;">
                        <strong>Country:</strong> ${car.manufacturer.country}<br>
                        <strong>Founded:</strong> ${car.manufacturer.foundedYear}
                    </div>
                </c:when>
                <c:otherwise>
                    <select id="manufacturerId" name="manufacturerId" required>
                        <option value="">Select Manufacturer</option>
                        <c:forEach var="manufacturer" items="${manufacturers}">
                            <option value="${manufacturer.id}"
                                ${car != null && car.manufacturer.id == manufacturer.id ? 'selected' : ''}>
                                    ${manufacturer.name} (${manufacturer.country})
                            </option>
                        </c:forEach>
                    </select>
                </c:otherwise>
            </c:choose>
        </div>

        <div class="form-group">
            <label for="carParkId">Car Park:</label>
            <c:choose>
                <c:when test="${mode == 'view'}">
                    <input type="text" readonly value="${car.carPark.name} (ID: ${car.carPark.id})" />
                    <div style="margin-top: 10px;">
                        <strong>Address:</strong> ${car.carPark.address}<br>
                        <strong>Capacity:</strong> ${car.carPark.capacity}
                    </div>
                </c:when>
                <c:otherwise>
                    <select id="carParkId" name="carParkId" required>
                        <option value="">Select Car Park</option>
                        <c:forEach var="carPark" items="${carParks}">
                            <option value="${carPark.id}"
                                ${car != null && car.carPark.id == carPark.id ? 'selected' : ''}>
                                    ${carPark.name} (${carPark.address})
                            </option>
                        </c:forEach>
                    </select>
                </c:otherwise>
            </c:choose>
        </div>

        <div class="form-group">
            <c:if test="${mode != 'view'}">
                <button type="submit" class="btn btn-primary">
                        ${mode == 'edit' ? 'Update' : 'Create'} Car
                </button>
            </c:if>
            <a href="cars" class="btn btn-secondary">Back to List</a>
        </div>
    </form>
</div>
</body>
</html>