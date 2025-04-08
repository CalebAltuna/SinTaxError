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
      <div class="container d-flex flex-wrap justify-content-between align-items-center">
        <a href="/" class="d-flex mb-2 mb-lg-0 text-dark text-decoration-none">
          <img src="https://www.fpdebagoienalh.com/wp-content/uploads/2020/10/miguel-altuna-logo.jpg" width="50%">
        </a>

        <center><ul class="nav me-auto mb-2 mb-md-0">
          <li class="nav-item"><a href="#" class="nav-link px-2 link-dark">Eraikina</a></li>
          <li class="nav-item"><a href="#" class="nav-link px-2 link-dark">Gela</a></li>
          <li class="nav-item"><a href="#" class="nav-link px-2 link-dark">Gailua</a></li>
          <li class="nav-item"><a href="#" class="nav-link px-2 link-dark">Erabiltzaileak</a></li>
          <li class="nav-item"><a href="#" class="nav-link px-2 link-dark">Historikoa</a></li>
        </ul></center>

        <div class="text-end">
          <button style="background-color: #35b5e6; border-color: #35b5e6;" type="button" class="btn btn-primary">Log-out</button>
        </div>
      </div>
    </header>
<center><div class="login-container">
        <h2>Login</h2>
        <form action="erabiltzaileakServlet" method="post">
            <input type="text" name="username" placeholder="Usuario" required>
            <input type="password" name="password" placeholder="Contraseña" required>
            <button style="width: 40%" type="submit" value="enviar">Ingresar</button>
        </form>
</div></center>
<footer>
	<p>By SinTaxError</p>
	<p>@Miguel Altuna 2025</p>
</footer>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
	
</body>
</html>