<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Log In</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" href="../NewFile.css">
</head>
<body>
<header class="py-3 mb-4 border-bottom">
  <div class="container-fluid d-flex justify-content-between align-items-center">
    <a href="/" class="d-flex align-items-center text-dark text-decoration-none">
      <img src="https://www.fpdebagoienalh.com/wp-content/uploads/2020/10/miguel-altuna-logo.jpg" alt="Logo" style="height: 50px;">
    </a>
    <ul class="nav justify-content-center flex-grow-1">
    <ul style="margin-left: -7%" class="nav justify-content-center flex-grow-1">
      <li class="nav-item"><a href="#" class="nav-link px-3 link-dark">Eraikina</a></li>
      <li class="nav-item"><a href="#" class="nav-link px-3 link-dark">Gela</a></li>
      <li class="nav-item"><a href="#" class="nav-link px-3 link-dark">Gailua</a></li>
      <li class="nav-item"><a href="#" class="nav-link px-3 link-dark">Erabiltzaileak</a></li>
      <li class="nav-item"><a href="#" class="nav-link px-3 link-dark">Historikoa</a></li>
    </ul>
  </div>
</header>
<form action="/SinTaxError/Start/loginServlet" method="post">
    <input type="text" name="izena" placeholder="Usuario" required>
    <input type="password" name="pasahitza" placeholder="Contraseña" required>
    <input style="width: 40%" type="submit" value="enviar"></input>
</form>
    <div class="alert alert-danger">${error}</div>
    
    
<footer>
	<p>By SinTaxError</p>
	<p>@Miguel Altuna 2025</p>
</footer>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
