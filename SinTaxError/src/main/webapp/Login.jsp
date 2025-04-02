<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Log In</title>
<link rel="stylesheet" href="NewFile.css">
</head>
<body>
<header>
<img src="${pageContext.request.contextPath}/media/img/icon.png" alt="Icon">
</header>
<div class="login-container">
        <h2>Login</h2>
        <form action=AdminDB.jsp method="post">
            <input type="text" name="username" placeholder="Usuario" required>
            <input type="password" name="password" placeholder="Contraseña" required>
            <button type="submit">Ingresar</button>
        </form>
    </div>
	<footer>
		<p>By SinTaxError</p>
		<p>@Miguel Altuna 2025</p>
	</footer>
</body>
</html>