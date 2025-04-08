package modelo;

import java.sql.Date;

public class eraikina {
    int ID_Eraikina;
    String Izen_Luzea;
    String Izen_Laburra;
    String Helbidea;
    String Posta_Kodea;
    Date Sortu_Data;
    
    
	public eraikina(int iD_Eraikina, String izen_Luzea, String Izen_Laburra, String helbidea, String posta_Kodea,
			Date sortu_Data) {
		super();
		ID_Eraikina = iD_Eraikina;
		Izen_Luzea = izen_Luzea;
		this.Izen_Laburra = Izen_Laburra;
		Helbidea = helbidea;
		Posta_Kodea = posta_Kodea;
		Sortu_Data = sortu_Data;
	}

	public int getID_Eraikina() {
		return ID_Eraikina;
	}

	public void setID_Eraikina(int iD_Eraikina) {
		ID_Eraikina = iD_Eraikina;
	}


	public String getIzen_Luzea() {
		return Izen_Luzea;
	}


	public void setIzen_Luzea(String izen_Luzea) {
		Izen_Luzea = izen_Luzea;
	}


	public String getIzen_Laburra() {
		return Izen_Laburra;
	}

	public void setIzen_Laburra(String izen_Laburra) {
		this.Izen_Laburra = izen_Laburra;
	}

	public String getHelbidea() {
		return Helbidea;
	}


	public void setHelbidea(String helbidea) {
		Helbidea = helbidea;
	}

	public String getPosta_Kodea() {
		return Posta_Kodea;
	}

	public void setPosta_Kodea(String posta_Kodea) {
		Posta_Kodea = posta_Kodea;
	}

	public Date getSortu_Data() {
		return Sortu_Data;
	}

	public void setSortu_Data(Date sortu_Data) {
		Sortu_Data = sortu_Data;
	}
	
}
