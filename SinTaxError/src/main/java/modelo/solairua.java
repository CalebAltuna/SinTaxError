package modelo;


public class solairua{
	int ID_Solairua;
    String Deskribapena;
    int ID_Eraikina;
    
	public solairua(int iD_Solairua, String deskribapena, int iD_Eraikina) {
		super();
		ID_Solairua = iD_Solairua;
		Deskribapena = deskribapena;
		ID_Eraikina = iD_Eraikina;
	}

	public int getID_Solairua() {
		return ID_Solairua;
	}

	public void setID_Solairua(int iD_Solairua) {
		ID_Solairua = iD_Solairua;
	}

	public String getDeskribapena() {
		return Deskribapena;
	}

	public void setDeskribapena(String deskribapena) {
		Deskribapena = deskribapena;
	}

	public int getID_Eraikina() {
		return ID_Eraikina;
	}

	public void setID_Eraikina(int iD_Eraikina) {
		ID_Eraikina = iD_Eraikina;
	}
    
    
    
	}
