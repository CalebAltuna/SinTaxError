<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
<title>Erab View</title>
<link rel="stylesheet" href="../NewFile.css">
</head>
<body>
<header class="py-3 mb-4 border-bottom">
  <div class="container-fluid d-flex justify-content-between align-items-center">
    <a href="/" class="d-flex align-items-center text-dark text-decoration-none">
      <img src="https://www.fpdebagoienalh.com/wp-content/uploads/2020/10/miguel-altuna-logo.jpg" alt="Logo" style="height: 50px;">
    </a>

    <ul class="nav justify-content-center flex-grow-1">
      <li class="nav-item"><a href="#" class="nav-link px-3 link-dark">Eraikina</a></li>
      <li class="nav-item"><a href="#" class="nav-link px-3 link-dark">Gela</a></li>
      <li class="nav-item"><a href="#" class="nav-link px-3 link-dark">Gailua</a></li>
      <li class="nav-item"><a href="#" class="nav-link px-3 link-dark">Erabiltzaileak</a></li>
      <li class="nav-item"><a href="#" class="nav-link px-3 link-dark">Historikoa</a></li>
    </ul>

    <div>
      <button type="button" class="btn btn-primary" style="background-color: #35b5e6; border-color: #35b5e6;">Log-out</button>
    </div>
  </div>
</header>
<%@ page import="java.sql.*"%>

<%

Connection conn = null;
Statement stm = null;
ResultSet rst = null;

try{
	Class.forName(driver);

	conn = DriverManager.getConnection(url,user,password);
	
	stm = conn.createStatement();
	
	String sententzia = "SELECT * FROM sintaxerror.erabiltzailea";
	
	rst = stm.executeQuery(sententzia);

%>

<table>
	<tr>
		<th>ID</th>
		<th>Izena</th>
		<th>Pasahitza</th>
		<th>Rol</th>
	</tr>

<%
while(rst.next()){
%>

<tr>
	<td><%= rst.getInt("id_erabiltzailea") %></td>
    <td><%= rst.getString("Izena") %></td>
    <td><%= rst.getString("Pasahitza") %></td>
    <td><%= rst.getString("Rola") %></td>
</tr>

<%
}
%>

</table>

<%
conn.close();
}
catch(Exception e){
	out.println(e);
}
%>
<div id="botones">
	<br>
	<button id="buttonOperar" type="button">Crear</button>
	<br>
	<button id="buttonOperar" type="button">Editar</button>
	<br>
	<button id="buttonOperar" type="button">Eliminar</button>
</div>
<footer>
		<p>By SinTaxError</p>
		<p>@Miguel Altuna 2025</p>
</footer>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>