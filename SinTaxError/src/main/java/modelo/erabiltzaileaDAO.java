package modelo;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Connection;
import java.util.ArrayList;
public class erabiltzaileaDAO {
    public void insertErabiltzailea(erabiltzailea erab) {
        try {
            Connection conn = DBconnection.getConnection();
            String sql = "INSERT INTO usuarios (ID_Erabiltzailea,Pasahitza,Rola,Izena) VALUES (?,?,?,?)";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setInt(1, erab.getID_Erabiltzailea());
            pst.setString(2, erab.getIzena());
            pst.setString(3, erab.getPasahitza());
            pst.setString(4, erab.getRola());
            pst.execute();
            DBconnection.desConnection();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

	public void deleteErabiltzailea(int id) {
		try {
			Connection conn = DBconnection.getConnection();
			String sql = "DELETE FROM usuarios WHERE ID_Erabiltzailea=?";
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setInt(1, id);
			pst.execute();
			DBconnection.desConnection();
		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
		}
	}
}
