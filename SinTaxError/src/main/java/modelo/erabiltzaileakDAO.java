
package modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Connection;
import java.util.ArrayList;

public class erabiltzaileakDAO {

    public void insertErabiltzaileak(erabiltzaileak e) {
        try {
            Connection conn = DBconnection.connect();
            String sql = "INSERT INTO usuarios (nombre, email, password) VALUES (?, ?, ?)";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, e.getIzena());
            pst.setString(2, e.getGmail());
            pst.setString(3, e.getPasahitza());

            pst.execute();
            DBconnection.desconnect();
        } catch (Exception ex) {
            System.out.println("Error: " + ex.getMessage());
        }
    }

    void deleteErabiltzaileak(int id) {
        try {
            Connection conn = DBconnection.connect();
            String sqlSententzia = "DELETE FROM securedb.usuarios where id = " + id;
            PreparedStatement pst = conn.prepareStatement(sqlSententzia);
            pst.execute();
            DBconnection.desconnect();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    ArrayList<erabiltzaileak> selectErabiltzaileak() {
        ArrayList<erabiltzaileak> erabiltzaileak = new ArrayList<>();
        try {
            Connection conn = DBconnection.connect();
            String sqlSententzia = "SELECT * from securedb.usuarios";
            PreparedStatement pst = conn.prepareStatement(sqlSententzia);
            ResultSet rst = pst.executeQuery();
            while (rst.next()) {
                erabiltzaileak e1 = new erabiltzaileak(rst.getString(1), rst.getString(2), rst.getString(3));
                erabiltzaileak.add(e1);
            }
            DBconnection.desconnect();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        return erabiltzaileak;
    }

    public void updateErabiltzailea(erabiltzaileak erabiltzailea) {
        try {
            Connection conn = DBconnection.connect();
            String sqlSententzia = "update erabiltzaileak set nombre = ?, gmail = ?,password = ? ";
            PreparedStatement pst = conn.prepareStatement(sqlSententzia);
            pst.setString(1, erabiltzailea.getIzena());
            pst.setString(2, erabiltzailea.getGmail());
            pst.setString(3, erabiltzailea.getPasahitza());
            pst.execute();
            DBconnection.desconnect();
        } catch (Exception e) {
            System.out.println("ERROR: " + e.getMessage());
        }
    }

    public static String devolverNombreBaseDeDatos(String nombreBuscado) {
        String izenaOk = null;
        try {
            Connection conn = DBconnection.connect();
            String sqlSententzia = "SELECT nombre FROM securedb.usuarios WHERE nombre = ? LIMIT 1";
            PreparedStatement pst = conn.prepareStatement(sqlSententzia);
            pst.setString(1, nombreBuscado);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                izenaOk = rs.getString("nombre");
            }
            rs.close();
            pst.close();
            DBconnection.desconnect();
        } catch (Exception e) {
            System.out.println("ERROR: " + e.getMessage());
        }
        return izenaOk;
    }

    public static String devolverPasswordBaseDeDatos(String nombreUsuario) {
        String pasahitza = null;
        try {
            Connection conn = DBconnection.connect();
            String sqlSententzia = "SELECT password FROM securedb.usuarios WHERE nombre = ? LIMIT 1";
            PreparedStatement pst = conn.prepareStatement(sqlSententzia);
            pst.setString(1, nombreUsuario);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                pasahitza = rs.getString("password");
            }
            rs.close();
            pst.close();
            DBconnection.desconnect();
        } catch (Exception e) {
            System.out.println("ERROR: " + e.getMessage());
        }
        return pasahitza;
    }
}
