<%@ page isErrorPage="true" contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Щось пішло не так</title>
    <style>
        body {
            font-family: sans-serif;
            text-align: center;
            padding-top: 100px;
            background-color: #f7f7f7;
        }
        img {
            width: 200px;
            margin-bottom: 30px;
        }
        .btn {
            background-color: #4285f4;
            color: white;
            padding: 12px 24px;
            border: none;
            border-radius: 4px;
            font-size: 16px;
            text-decoration: none;
        }
    </style>
</head>
<body>
<img src="https://i.pinimg.com/736x/d6/b4/ce/d6b4ce6f1f5e0e8eb920eb74dcba8fde.jpg" alt="Error image" />
<h1>Виникла помилка......</h1>
<a href="<%= request.getContextPath() %>/" class="btn">Повернутись на головну</a>
</body>
</html>
