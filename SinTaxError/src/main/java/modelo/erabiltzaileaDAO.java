package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class erabiltzaileaDAO {
	private final String SELECT_USER = "SELECT * FROM sintaxerror.erabiltzailea";
	private final String CREATE_USER = "INSERT INTO sintaxerror.erabiltzailea (ID_Erabiltzailea,Pasahitza,Rola,Izena) VALUES (?,?,?,?)";
	private final String DELETE_USER = "DELETE FROM sintaxerror.erabiltzailea WHERE ID_Erabiltzailea=?";
	private final String UPDATE_USER = "UPDATE sintaxerror.erabiltzailea SET Pasahitza=?, Rola=?, Izena=? WHERE ID_Erabiltzailea=?";

	public void irakurriErab() {
		Connection conn = null;
		PreparedStatement pst = null;
		try {
			conn = DBconnection.connect();
			pst = conn.prepareStatement(SELECT_USER);
			pst.executeQuery();
		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
		} finally {
			try {
				if (pst != null) pst.close();
				if (conn != null) conn.close();
			} catch (Exception e) {
				System.out.println("Error closing resources: " + e.getMessage());
			}
		}
	}

	public void sortuErab(erabiltzailea erab) {
		Connection conn = null;
		PreparedStatement pst = null;
		try {
			conn = DBconnection.connect();
			pst = conn.prepareStatement(CREATE_USER);
			pst.setInt(1, erab.getID_Erabiltzailea());
			pst.setString(2, erab.getPasahitza());
			pst.setString(3, erab.getRola());
			pst.setString(4, erab.getIzena());
			pst.execute();
		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
		} finally {
			try {
				if (pst != null) pst.close();
				if (conn != null) conn.close();
			} catch (Exception e) {
				System.out.println("Error closing resources: " + e.getMessage());
			}
		}
	}

	public void kenduErab(int id) {
		Connection conn = null;
		PreparedStatement pst = null;
		try {
			conn = DBconnection.connect();
			pst = conn.prepareStatement(DELETE_USER);
			pst.setInt(1, id);
			pst.execute();
		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
		} finally {
			try {
				if (pst != null) pst.close();
				if (conn != null) conn.close();
			} catch (Exception e) {
				System.out.println("Error closing resources: " + e.getMessage());
			}
		}
	}

	public void eguneratuErab(erabiltzailea erab) {
		Connection conn = null;
		PreparedStatement pst = null;
		try {
			conn = DBconnection.connect();
			pst = conn.prepareStatement(UPDATE_USER);
			pst.setString(1, erab.getPasahitza());
			pst.setString(2, erab.getRola());
			pst.setString(3, erab.getIzena());
			pst.setInt(4, erab.getID_Erabiltzailea());
			pst.execute();
		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
		} finally {
			try {
				if (pst != null) pst.close();
				if (conn != null) conn.close();
			} catch (Exception e) {
				System.out.println("Error closing resources: " + e.getMessage());
			}
		}
	}
	
	public static boolean validar(String izena, String pasahitza) {
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		boolean isValid = false;

		try {
			conn = DBconnection.connect();
			String sql = "SELECT izena FROM sintaxerror.erabiltzailea WHERE izena=? AND pasahitza=?";
			pst = conn.prepareStatement(sql);
			pst.setString(1, izena);
			pst.setString(2, pasahitza);
			rs = pst.executeQuery();
			if (rs.next()) {
				isValid = true;
			}
		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
		} finally {
			try {
				if (rs != null) rs.close();
				if (pst != null) pst.close();
				if (conn != null) conn.close();
			} catch (Exception e) {
				System.out.println("Error closing resources: " + e.getMessage());
			}
		}
		return isValid;
	}
}
