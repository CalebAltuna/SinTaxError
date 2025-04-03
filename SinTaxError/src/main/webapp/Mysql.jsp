<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MySQL konexioa</title>
<link rel="stylesheet" href="NewFile.css">
</head>
<body>

<%@ page import="java.sql.*"%>

<%

final String user = "root";
final String password = "12345678";
final String datubase_izena = "securedb";
final String  url = "jdbc:mysql://127.0.0.1:3306/"+datubase_izena;
final String driver = "com.mysql.cj.jdbc.Driver";

Connection conn = null;
Statement stm = null;
ResultSet rst = null;

try{
	Class.forName(driver);

	conn = DriverManager.getConnection(url,user,password);
	
	stm = conn.createStatement();
	
	String sententzia = "SELECT * FROM securedb.usuarios";
	
	rst = stm.executeQuery(sententzia);

%>

<table>
	<tr>
		<th>ID</th>
		<th>Izena</th>
	</tr>

<%
while(rst.next()){
%>

<tr>
	<td><%= rst.getInt("id") %></td>
    <td><%= rst.getString("nombre") %></td>
    <td><%= rst.getString("email") %></td>
    <td><%= rst.getString("password") %></td>
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
	<footer>
		<p>By SinTaxError</p>
		<p>@Miguel Altuna 2025</p>
</body>
</html>