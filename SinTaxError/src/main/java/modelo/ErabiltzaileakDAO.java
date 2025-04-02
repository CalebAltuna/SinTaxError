
package modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Connection;
import java.util.ArrayList;

public class ErabiltzaileakDAO {

    public ErabiltzaileakDAO() {
    }

    public void insertErabiltzaileak(erabiltzaileak e) {
        try {
            Connection conn = DBconnection.getConnection();
            String sql = "INSERT INTO usuarios (nombre, email, password) VALUES (?, ?, ?)";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, e.getIzena());
            pst.setString(2, e.getGmail());
            pst.setString(3, e.getPassword());

            pst.execute();
            DBconnection.desConnection();
        } catch (Exception ex) {
            System.out.println("Error: " + ex.getMessage());
        }
    }

    void deleteErabiltzaileak(int id) {
        try {
            Connection conn = DBconnection.getConnection();
            String sqlSententzia = "DELETE FROM securedb.usuarios where id = " + id;
            PreparedStatement pst = conn.prepareStatement(sqlSententzia);
            pst.execute();
            DBconnection.desConnection();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    ArrayList<erabiltzaileak> selectErabiltzaileak() {
        ArrayList<erabiltzaileak> erabiltzaileak = new ArrayList<>();
        try {
            Connection conn = DBconnection.getConnection();
            String sqlSententzia = "SELECT * from securedb.usuarios";
            PreparedStatement pst = conn.prepareStatement(sqlSententzia);
            ResultSet rst = pst.executeQuery();
            while (rst.next()) {
                erabiltzaileak e1 = new erabiltzaileak(rst.getString(1), rst.getString(2), rst.getString(3));
                erabiltzaileak.add(e1);
            }
            DBconnection.desConnection();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        return erabiltzaileak;
    }

    public void updateErabiltzailea(erabiltzaileak erabiltzailea) {
        try {
            Connection conn = DBconnection.getConnection();
            String sqlSententzia = "update erabiltzaileak set nombre = ?, gmail = ?,password = ? ";
            PreparedStatement pst = conn.prepareStatement(sqlSententzia);
            pst.setString(1, erabiltzailea.getIzena());
            pst.setString(2, erabiltzailea.getGmail());
            pst.setString(3, erabiltzailea.getPassword());
            pst.execute();
            DBconnection.desConnection();
        } catch (Exception e) {
            System.out.println("ERROR: " + e.getMessage());
        }
    }

    public String devolverNombreBaseDeDatos(String nombreBuscado) {
        String nombreEncontrado = null;
        try {
            Connection conn = DBconnection.getConnection();
            String sqlSententzia = "SELECT nombre FROM securedb.usuarios WHERE nombre = ? LIMIT 1";
            PreparedStatement pst = conn.prepareStatement(sqlSententzia);
            pst.setString(1, nombreBuscado);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                nombreEncontrado = rs.getString("nombre");
            }
            rs.close();
            pst.close();
            DBconnection.desConnection();
        } catch (Exception e) {
            System.out.println("ERROR: " + e.getMessage());
        }
        return nombreEncontrado;
    }

    public String devolverPasswordBaseDeDatos(String nombreUsuario) {
        String password = null;
        try {
            Connection conn = DBconnection.getConnection();
            String sqlSententzia = "SELECT password FROM securedb.usuarios WHERE nombre = ? LIMIT 1";
            PreparedStatement pst = conn.prepareStatement(sqlSententzia);
            pst.setString(1, nombreUsuario);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                password = rs.getString("password");
            }
            rs.close();
            pst.close();
            DBconnection.desConnection();
        } catch (Exception e) {
            System.out.println("ERROR: " + e.getMessage());
        }
        return password;
    }
}
