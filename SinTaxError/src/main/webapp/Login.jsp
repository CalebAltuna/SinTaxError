<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
<link rel="stylesheet" href="NewFile.css">
</head>
<body>
<header>
<h1>Miguel Altuna DB - by SinTaxError</h1>
</header>
<div class="login-container">
        <h2>Login</h2>
        <form action=second.jsp method="post">
            <input type="text" name="username" placeholder="Usuario" required>
            <input type="password" name="password" placeholder="Contraseña" required>
            <button type="submit">Ingresar</button>
        </form>
    </div>
</body>
</html>