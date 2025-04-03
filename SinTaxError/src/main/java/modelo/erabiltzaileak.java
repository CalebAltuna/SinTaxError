package modelo;

public class erabiltzaileak {
	String izena, gmail,password;
	int id;
	
	public erabiltzaileak(String izena, String gmail, String password, int id) {
		super();
		this.izena = izena;
		this.gmail = gmail;
		this.password = password;
		this.id = id;
	}

	public erabiltzaileak(String izena, String gmail, String password) {
		super();
		this.izena = izena;
		this.gmail = gmail;
		this.password = password;
	}
	
	public erabiltzaileak(String izena, String gmail, int id) {
		super();
		this.izena = izena;
		this.gmail = gmail;
		this.id = id;
	}
	
	public erabiltzaileak(String izena, String password) {
		super();
		this.izena = izena;
		this.password = password;
	}


	public String getIzena() {
		return izena;
	}

	public void setIzena(String izena) {
		this.izena = izena;
	}

	public String getGmail() {
		return gmail;
	}

	public void setGmail(String gmail) {
		this.gmail = gmail;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}//endClass
