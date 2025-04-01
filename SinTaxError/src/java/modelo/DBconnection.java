package modelo;

public class DBconnection {
private static final String URL = "jdbc:mysql://localhost:3306/miBaseDeDatos";
private static final String USER = "root";
private static final String PASSWORD ="";

public static Connection getConnection() throws SQLException {
    try {
        Class.forName("com.mysql.cj.jdbc.Driver"); // Cargar el driver
        return DriverManager.getConnection(URL, USER, PASSWORD);
    } catch (ClassNotFoundException e) {
        throw new SQLException("Error al cargar el driver", e);
    }
}
}
