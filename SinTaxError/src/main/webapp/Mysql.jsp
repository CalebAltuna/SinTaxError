<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MySQL konexioa</title>
</head>
<body>

<%@ page import="java.sql.*"%>

<%

final String user = "root";
final String password = "123456789";
final String datubase_izena = "prueba";
final String  url = "jdbc:mysql://localhost:3306/"+datubase_izena;
final String driver = "com.mysql.cj.jdbc.Driver";

Connection conn = null;
Statement stm = null;
ResultSet rst = null;

try{
	Class.forName(driver);

	conn = DriverManager.getConnection(url,user,password);
	
	stm = conn.createStatement();
	
	String sententzia = "SELECT * FROM prueba.erabiltzaileak";
	
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
    <td><%= rst.getString("izena") %></td>
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

</body>
</html>