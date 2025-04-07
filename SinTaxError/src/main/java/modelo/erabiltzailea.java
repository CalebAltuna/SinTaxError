package modelo;

public class erabiltzailea {
	int ID_Erabiltzailea;
	String Pasahitza;
	String Rola;
	
	public erabiltzailea(int iD_Erabiltzailea, String pasahitza, String rola) {
		super();
		ID_Erabiltzailea = iD_Erabiltzailea;
		Pasahitza = pasahitza;
		Rola = rola;
	}
	
	public int getID_Erabiltzailea() {
		return ID_Erabiltzailea;
	}
	public void setID_Erabiltzailea(int iD_Erabiltzailea) {
		ID_Erabiltzailea = iD_Erabiltzailea;
	}
	public String getPasahitza() {
		return Pasahitza;
	}
	public void setPasahitza(String pasahitza) {
		Pasahitza = pasahitza;
	}
	public String getRola() {
		return Rola;
	}
	public void setRola(String rola) {
		Rola = rola;
	}
	
	
}
