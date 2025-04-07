package modelo;

import java.sql.Date;

public class gailua {
	int SN_Zenbakia;
	String HZ_Zenbakia;
	String Deskribapena;
	String Mota;
	String Ikasturtea;
	int ID_Gela;
	int ID_Erabiltzailea;
	Date Hasiera_data_Gela;
	Date Hasiera_data_Erabiltzailea;
	Date Bukaera_data_Gela;
	Date Bukaera_data_Erabiltzailea;
	
	public gailua(int sN_Zenbakia, String hZ_Zenbakia, String deskribapena, String mota, String ikasturtea, int iD_Gela,
			int iD_Erabiltzailea, Date hasiera_data_Gela, Date hasiera_data_Erabiltzailea, Date bukaera_data_Gela,
			Date bukaera_data_Erabiltzailea) {
		super();
		SN_Zenbakia = sN_Zenbakia;
		HZ_Zenbakia = hZ_Zenbakia;
		Deskribapena = deskribapena;
		Mota = mota;
		Ikasturtea = ikasturtea;
		ID_Gela = iD_Gela;
		ID_Erabiltzailea = iD_Erabiltzailea;
		Hasiera_data_Gela = hasiera_data_Gela;
		Hasiera_data_Erabiltzailea = hasiera_data_Erabiltzailea;
		Bukaera_data_Gela = bukaera_data_Gela;
		Bukaera_data_Erabiltzailea = bukaera_data_Erabiltzailea;
	}
	public int getSN_Zenbakia() {
		return SN_Zenbakia;
	}
	public void setSN_Zenbakia(int sN_Zenbakia) {
		SN_Zenbakia = sN_Zenbakia;
	}
	public String getHZ_Zenbakia() {
		return HZ_Zenbakia;
	}
	public void setHZ_Zenbakia(String hZ_Zenbakia) {
		HZ_Zenbakia = hZ_Zenbakia;
	}
	public String getDeskribapena() {
		return Deskribapena;
	}
	public void setDeskribapena(String deskribapena) {
		Deskribapena = deskribapena;
	}
	public String getMota() {
		return Mota;
	}
	public void setMota(String mota) {
		Mota = mota;
	}
	public String getIkasturtea() {
		return Ikasturtea;
	}
	public void setIkasturtea(String ikasturtea) {
		Ikasturtea = ikasturtea;
	}
	public int getID_Gela() {
		return ID_Gela;
	}
	public void setID_Gela(int iD_Gela) {
		ID_Gela = iD_Gela;
	}
	public int getID_Erabiltzailea() {
		return ID_Erabiltzailea;
	}
	public void setID_Erabiltzailea(int iD_Erabiltzailea) {
		ID_Erabiltzailea = iD_Erabiltzailea;
	}
	public Date getHasiera_data_Gela() {
		return Hasiera_data_Gela;
	}
	public void setHasiera_data_Gela(Date hasiera_data_Gela) {
		Hasiera_data_Gela = hasiera_data_Gela;
	}
	public Date getHasiera_data_Erabiltzailea() {
		return Hasiera_data_Erabiltzailea;
	}
	public void setHasiera_data_Erabiltzailea(Date hasiera_data_Erabiltzailea) {
		Hasiera_data_Erabiltzailea = hasiera_data_Erabiltzailea;
	}
	public Date getBukaera_data_Gela() {
		return Bukaera_data_Gela;
	}
	public void setBukaera_data_Gela(Date bukaera_data_Gela) {
		Bukaera_data_Gela = bukaera_data_Gela;
	}
	public Date getBukaera_data_Erabiltzailea() {
		return Bukaera_data_Erabiltzailea;
	}
	public void setBukaera_data_Erabiltzailea(Date bukaera_data_Erabiltzailea) {
		Bukaera_data_Erabiltzailea = bukaera_data_Erabiltzailea;
	}
	
	
}
