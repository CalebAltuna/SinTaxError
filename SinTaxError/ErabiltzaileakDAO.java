package modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Connection;
import java.util.ArrayList;

import org.apache.tomcat.dbcp.dbcp2.PoolablePreparedStatement;

public class ErabiltzaileakDAO {
	
	public ErabiltzaileakDAO() {
		
	}
	
    public void insertErabiltzaileak(Erabiltzaileak e) {
        try {
            Konexioa.konektatu();
            Connection conn = Konexioa.getConnection();
            String sql = "INSERT INTO usuarios (nombre, email, password) VALUES (?, ?, ?)";
            PreparedStatement pst = conn.prepareStatement(sql);
            
            pst.setString(1, e.getIzena());
            pst.setString(2, e.getGmail());
            pst.setString(3, e.getPassword());
            
            pst.execute();
            
            Konexioa.deskonektatu();
        } catch (Exception ex) {
            System.out.println("Error: " + ex.getMessage());
        }
    }//endMethod
	
	void deleteErabiltzaileak(int id) {
		//abrimos la konexion
		Konexioa.konektatu();
		String sqlSententzia= "DELETE FROM securedb.usuarios where id = "+id;
		try {
			PreparedStatement pst = Konexioa.getConnection().prepareStatement(sqlSententzia);
			pst.execute();
		}catch (Exception e) {
			System.out.println("Error: "+e.getMessage());
		}
		Konexioa.deskonektatu();
	}//endMethod
	
	ArrayList<Erabiltzaileak> selectErabiltzaileak(){
		ArrayList<Erabiltzaileak> erabiltzaileak = new ArrayList<>();
		PreparedStatement pst;
		ResultSet rst;
		String sqlSententzia = "SELECT * from securedb.usuarios";
		Konexioa.konektatu();
		try {
			pst = Konexioa.getConnection().prepareStatement(sqlSententzia);
			rst = pst.executeQuery();
			while(rst.next()) {
				Erabiltzaileak e1 = new Erabiltzaileak(rst.getString(1), rst.getString(2), rst.getString(3));
				erabiltzaileak.add(e1);
			}
		}catch (Exception e) {
			System.out.println("Error: "+e.getMessage());
		}
		
		Konexioa.deskonektatu();
		return erabiltzaileak;
	}//endMethod
	
	public void updateErabiltzailea(Erabiltzaileak erabiltzailea) {
		Konexioa.konektatu();
		String sqlSententzia = "update erabiltzaileak set nombre = ?, gmail = ?,password = ? ";
		try {
			PreparedStatement pst = Konexioa.getConnection().prepareStatement(sqlSententzia);
			pst.setString(1, erabiltzailea.getIzena());
			pst.setString(2, erabiltzailea.getGmail());
			pst.setString(3, erabiltzailea.getPassword());
			pst.execute();
			Konexioa.deskonektatu();
		}catch(Exception e) {
			System.out.println("ERROR: "+ e.getMessage());
		}
	}//endMethod
	
	public String devolverNombreBaseDeDatos(String nombreBuscado) {
	    String nombreEncontrado = null;
	    String sqlSententzia = "SELECT nombre FROM securedb.usuarios WHERE nombre = ? LIMIT 1";
	    
	    try {
	        Konexioa.konektatu();
	        PreparedStatement pst = Konexioa.getConnection().prepareStatement(sqlSententzia);
	        pst.setString(1, nombreBuscado);
	        
	        ResultSet rs = pst.executeQuery();  // <-- Obtener resultados
	        
	        if(rs.next()) {  // <-- Verificar si hay coincidencias
	            nombreEncontrado = rs.getString("nombre");
	        }
	        rs.close();
	        pst.close();
	    } catch(Exception e) {
	        System.out.println("ERROR: "+e.getMessage());
	    } finally {  // <-- Asegurar que la conexión se cierre siempre
	        Konexioa.deskonektatu();
	    }
	    
	    return nombreEncontrado;  // <-- Devuelve null si no encuentra el usuario
	}
	
	public String devolverPasswordBaseDeDatos(String nombreUsuario) {
	    String password = null;
	    String sqlSententzia = "SELECT password FROM securedb.usuarios WHERE nombre = ? LIMIT 1";
	    
	    try {
	        Konexioa.konektatu();
	        PreparedStatement pst = Konexioa.getConnection().prepareStatement(sqlSententzia);
	        pst.setString(1, nombreUsuario);
	        
	        ResultSet rs = pst.executeQuery();
	        
	        if(rs.next()) {
	            password = rs.getString("password");
	        }
	        rs.close();
	        pst.close();
	    } catch(Exception e) {
	        System.out.println("ERROR: "+e.getMessage());
	    } finally {
	        Konexioa.deskonektatu();
	    }
	    
	    return password;
	}
	
}//endClass