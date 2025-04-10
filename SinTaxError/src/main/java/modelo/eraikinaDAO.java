package modelo;
import java.sql.PreparedStatement;
import java.sql.Connection;
public class eraikinaDAO {
	public void sortuEraikina(eraikina eraikin) {
		try {
			Connection conn = DBconnection.connect();
			String sql = "INSERT INTO eraikinak (ID_Eraikina,Izen_Luzea,Izen_Laburra,Helbidea,Posta_Kodea,Sortu_Data) VALUES (?,?,?,?,?)";
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setInt(1, eraikin.getID_Eraikina());
			pst.setString(2, eraikin.getIzen_Luzea());
			pst.setString(4, eraikin.getIzen_Laburra());
			pst.setString(4, eraikin.getHelbidea());
			pst.setDate(5, eraikin.getSortu_Data());
			pst.execute();
			DBconnection.connect();
		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
		}
	}
}
