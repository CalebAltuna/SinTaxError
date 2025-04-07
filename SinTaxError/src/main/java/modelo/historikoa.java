package modelo;

import java.sql.Date;

public class historikoa {
	int ID_Historikoa;
	Date Data;
	int ID_Erabiltzailea;
	
	public historikoa(int iD_Historikoa, Date data, int iD_Erabiltzailea) {
		super();
		ID_Historikoa = iD_Historikoa;
		Data = data;
		ID_Erabiltzailea = iD_Erabiltzailea;
	}
	public int getID_Historikoa() {
		return ID_Historikoa;
	}
	public void setID_Historikoa(int iD_Historikoa) {
		ID_Historikoa = iD_Historikoa;
	}
	public Date getData() {
		return Data;
	}
	public void setData(Date data) {
		Data = data;
	}
	public int getID_Erabiltzailea() {
		return ID_Erabiltzailea;
	}
	public void setID_Erabiltzailea(int iD_Erabiltzailea) {
		ID_Erabiltzailea = iD_Erabiltzailea;
	}
	
	
}
