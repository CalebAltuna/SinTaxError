
package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBconnection {
    private static final String USER = System.getenv("DB_USER"); // Usar variables de entorno
    private static final String PASSWORD = System.getenv("DB_PASSWORD");
    private static final String URL = System.getenv("DB_URL");
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";

    public static Connection connect() {
        Connection conn = null;
        try {
            Class.forName(DRIVER); // Cargar el driver
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Conexión exitosa a la base de datos.");
        } catch (ClassNotFoundException e) {
            System.err.println("Error: Driver no encontrado - " + e.getMessage());
        } catch (SQLException e) {
            System.err.println("Error al conectar a la base de datos - " + e.getMessage());
        }
        return conn;
    }

    public static void disconnect(Connection conn) {
        try {
            if (conn != null && !conn.isClosed()) {
                conn.close();
                System.out.println("Conexión cerrada correctamente.");
            }
        } catch (SQLException e) {
            System.err.println("Error al cerrar la conexión - " + e.getMessage());
        }
    }
}
