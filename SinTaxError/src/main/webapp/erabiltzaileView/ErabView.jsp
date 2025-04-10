<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
<title>Erabiltzailea - View</title>
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
    Class.forName("com.mysql.cj.jdbc.Driver"); // Asegúrate de tener el driver de MySQL

    conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sintaxerror", "user", "password");

    stm = conn.createStatement();
    String query = "SELECT * FROM sintaxerror.erabiltzailea";
    rst = stm.executeQuery(query);
%>

<div class="container">
  <h2 class="my-4">Erabiltzaileen Zerrenda</h2>
  <table class="table table-striped table-bordered">
    <thead>
      <tr>
        <th>ID</th>
        <th>Izena</th>
        <th>Pasahitza</th>
        <th>Rol</th>
        <th>Ekintzak</th>
      </tr>
    </thead>
    <tbody>
<%
while(rst.next()) {
%>
      <tr>
        <td><%= rst.getInt("id_erabiltzailea") %></td>
        <td><%= rst.getString("Izena") %></td>
        <td><%= rst.getString("Pasahitza") %></td>
        <td><%= rst.getString("Rola") %></td>
        <td>
          <a href="editErabiltzailea.jsp?id=<%= rst.getInt("id_erabiltzailea") %>" class="btn btn-warning btn-sm">Editatu</a>
          <a href="deleteErabiltzailea.jsp?id=<%= rst.getInt("id_erabiltzailea") %>" class="btn btn-danger btn-sm">Ezabatu</a>
        </td>
      </tr>
<%
}
%>
    </tbody>
  </table>
</div>

<%
conn.close();
}
catch(Exception e){
  out.println("<p>Error: " + e.getMessage() + "</p>");
}
%>

<div class="container">
  <button id="createBtn" class="btn btn-success" data-bs-toggle="modal" data-bs-target="#createModal">Sortu Erabiltzailea</button>
</div>

<!-- Modal for Create -->
<div class="modal fade" id="createModal" tabindex="-1" aria-labelledby="createModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="createModalLabel">Sortu Erabiltzailea</h5>
        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
      </div>
      <div class="modal-body">
        <form action="createErabiltzailea.jsp" method="POST">
          <div class="mb-3">
            <label for="izena" class="form-label">Izena</label>
            <input type="text" class="form-control" id="izena" name="izena" required>
          </div>
          <div class="mb-3">
            <label for="pasahitza" class="form-label">Pasahitza</label>
            <input type="password" class="form-control" id="pasahitza" name="pasahitza" required>
          </div>
          <div class="mb-3">
            <label for="rola" class="form-label">Rol</label>
            <input type="text" class="form-control" id="rola" name="rola" required>
          </div>
          <button type="submit" class="btn btn-primary">Sortu</button>
        </form>
      </div>
    </div>
  </div>
</div>

<footer class="text-center py-4">
  <p>By SinTaxError</p>
  <p>@Miguel Altuna 2025</p>
</footer>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>

</body>
</html>
