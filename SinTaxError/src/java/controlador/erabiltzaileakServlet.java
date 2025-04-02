package controlador;

import java.io.IOException;

import Modeloa.Erabiltzaileak;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class erabiltzaileakServlet {
	public boolean loginTry(Erabiltzaileak erabiltzailea) {
		boolean vuelta = false;
		try {
			if(erabiltzailea.getIzena().equals(erabiltzaileakDAO.devolverNombreBaseDeDatos(erabiltzailea.getIzena())) && erabiltzailea.getPassword().equals(erabiltzaileakDAO.devolverPasswordBaseDeDatos(erabiltzailea.getIzena()))) {
				vuelta = true;
			}
			
		}catch(NullPointerException e) {
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
			response.sendRedirect("AdminDB.jsp");
		}else {
			response.sendRedirect("try.jsp");
		}
}
