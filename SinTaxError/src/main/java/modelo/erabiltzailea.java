package modelo;

public class erabiltzailea {
	int ID_Erabiltzailea;
	String Pasahitza;
	String Rola;
	String Izena;
	
	public erabiltzailea(int ID_Erabiltzailea, String Pasahitza, String Rola, String Izena) {
		super();
		ID_Erabiltzailea = this.ID_Erabiltzailea;
		Pasahitza = this.Pasahitza;
		Rola = this.Rola;
		Izena= this.Izena;
	}
	
	public erabiltzailea() {
		// TODO Auto-generated constructor stub
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
	public String getIzena() {
		return Izena;
	}
	public void setIzena(String izena) {
		Izena = izena;
	}
	
	
}
