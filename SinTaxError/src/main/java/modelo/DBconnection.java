
package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBconnection {
    private static final String USER = "root";
    private static final String PASSWORD = "12345678";
    private static final String URL = "jdbc:mysql://localhost:3306/securedb";
    final String driver = "com.mysql.cj.jdbc.Driver";
    private static Connection conn = null;

    public static Connection getConnection() {
        try {
            if (conn == null || conn.isClosed()) {
                conn = DriverManager.getConnection(URL, USER, PASSWORD);
                System.out.println("Konektatuta zaude");
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
        return conn;
    }
    public static void desConnection() {
        try {
            if (conn != null && !conn.isClosed()) {
                conn.close();
                System.out.println("Conexion cerrada");
            } else {
                System.out.println("La conexion no esta abierta");
            }
        } catch (SQLException e) {
            System.out.println("Ha ocurrido un problema al cerrar la conexion");
        }
    }
}