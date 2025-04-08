package modelo;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Connection;
import java.util.ArrayList;
public class erabiltzaileaDAO {
    public void sortuErab(erabiltzailea erab) {
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

	public void kenduErab(int id) {
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

	public void eguneratuErab(erabiltzailea erab) {
		try {
			Connection conn = DBconnection.getConnection();
			String sql = "UPDATE usuarios SET Pasahitza=?, Rola=?, Izena=? WHERE ID_Erabiltzailea=?";
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setString(1, erab.getPasahitza());
			pst.setString(2, erab.getRola());
			pst.setString(3, erab.getIzena());
			pst.setInt(4, erab.getID_Erabiltzailea());
			pst.execute();
			DBconnection.desConnection();
		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
		}
	}
}
