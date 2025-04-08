package modelo;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Connection;
import java.util.ArrayList;
public class erabiltzaileaDAO {
    public void insertErabiltzailea(erabiltzailea e) {
        try {
            Connection conn = DBconnection.getConnection();
            String sql = "INSERT INTO usuarios (ID_Erabiltzailea,Pasahitza,Rola,Izena) VALUES (?,?,?,?)";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setInt(1, e.getID_Erabiltzailea());
            pst.setString(2, e.getIzena());
            pst.setString(3, e.getPasahitza());
            pst.setString(4, e.getRola());
            pst.execute();
            DBconnection.desConnection();
        } catch (Exception ex) {
            System.out.println("Error: " + ex.getMessage());
        }
    }
}
