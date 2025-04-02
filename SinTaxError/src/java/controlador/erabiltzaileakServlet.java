package controlador;

import Modeloa.Erabiltzaileak;

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
}
