package controlador;

import java.io.IOException;

import Modeloa.Erabiltzaileak;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class erabiltzaileakServlet {
	public boolean recogerDatos(Erabiltzaileak erabiltzailea) {
	    boolean vuelta = false;
	    try {
	        String nombreBD = erabiltzaileakDAO.devolverNombreBaseDeDatos(erabiltzailea.getIzena());
	        String passwordBD = erabiltzaileakDAO.devolverPasswordBaseDeDatos(erabiltzailea.getIzena());
	
	        if (erabiltzailea.getIzena().equals(nombreBD) && erabiltzailea.getPassword().equals(passwordBD)) {
	            vuelta = true;
	        }
	    } catch (NullPointerException e) {
	        System.err.println("NullPointerException: " + e.getMessage());
	        vuelta = false;
	    } catch (Exception e) {
	        System.err.println("Exception: " + e.getMessage());
	        vuelta = false;
	    }
	    return vuelta;
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String nombreUsuario = request.getParameter("name");
		String password = request.getParameter("password");
		
		Erabiltzaileak erabiltzailea = new Erabiltzaileak(nombreUsuario, password);
		
		if(recogerdatos(erabiltzailea)) {
			response.sendRedirect("login.jsp");
		}else {
			response.sendRedirect("try.jsp");
		}
	}//endMethod
}
