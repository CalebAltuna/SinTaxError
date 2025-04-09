package modelo;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Connection;
public class erabiltzaileaDAO {
	private final String SELECT_USER="SELECT * FROM usuarios.sintaxerror";
	private final String CREATE_USER="INSERT INTO usuarios.sintaxerror (ID_Erabiltzailea,Pasahitza,Rola,Izena) VALUES (?,?,?,?)";
	private final String DELETE_USER="DELETE FROM usuarios.sintaxerror WHERE ID_Erabiltzailea=?";
	private final String UPDATE_USER="UPDATE usuarios SET Pasahitza=?, Rola=?, Izena=? WHERE ID_Erabiltzailea=?";
    
	public void irakurriErab() {
		try {
			Connection conn = DBconnection.connect();
			String sql = SELECT_USER;
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.executeQuery();
			DBconnection.desconnect();
		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
		}
	}

	public void sortuErab(erabiltzailea erab) {
        try {
            Connection conn = DBconnection.connect();
            String sql = CREATE_USER;
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setInt(1, erab.getID_Erabiltzailea());
            pst.setString(2, erab.getIzena());
            pst.setString(3, erab.getPasahitza());
            pst.setString(4, erab.getRola());
            pst.execute();
            DBconnection.desconnect();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
	public void kenduErab(int id) {
		try {
			Connection conn = DBconnection.connect();
			String sql = DELETE_USER;
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setInt(1, id);
			pst.execute();
			DBconnection.desconnect();
		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
		}
	}

	public void eguneratuErab(erabiltzailea erab) {
		try {
			Connection conn = DBconnection.connect();
			String sql =UPDATE_USER;
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setString(1, erab.getPasahitza());
			pst.setString(2, erab.getRola());
			pst.setString(3, erab.getIzena());
			pst.setInt(4, erab.getID_Erabiltzailea());
			pst.execute();
			DBconnection.desconnect();
		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
		}
	}
    public static String izenaBai(String sartutakoPassword) {
        String izenaOk = null;
        try {
            Connection conn = DBconnection.connect();
            String sqlSententzia = "SELECT nombre FROM securedb.usuarios WHERE nombre = ? LIMIT 1";
            PreparedStatement pst = conn.prepareStatement(sqlSententzia);
            pst.setString(1, sartutakoPassword);
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

    public static String pasahitzaBai(String sartutakoErab) {
        String pasahitza = null;
        try {
            Connection conn = DBconnection.connect();
            String sqlSententzia = "SELECT pasahitza FROM sintaxerror.usuarios WHERE izena = ? LIMIT 1";
            PreparedStatement pst = conn.prepareStatement(sqlSententzia);
            pst.setString(1, sartutakoErab);
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
