package modelo;

public class gela {
	int ID_Gela;
    String Deskribapena;
    int ID_Solairua;
    
	public gela(int iD_Gela, String deskribapena, int iD_Solairua) {
		super();
		ID_Gela = iD_Gela;
		Deskribapena = deskribapena;
		ID_Solairua = iD_Solairua;
	}

	public int getID_Gela() {
		return ID_Gela;
	}

	public void setID_Gela(int iD_Gela) {
		ID_Gela = iD_Gela;
	}

	public String getDeskribapena() {
		return Deskribapena;
	}

	public void setDeskribapena(String deskribapena) {
		Deskribapena = deskribapena;
	}

	public int getID_Solairua() {
		return ID_Solairua;
	}

	public void setID_Solairua(int iD_Solairua) {
		ID_Solairua = iD_Solairua;
	}
    
    
}
