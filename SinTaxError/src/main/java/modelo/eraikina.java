package modelo;

import java.sql.Date;

public class eraikina {
    int idEraikina;
    String izenLuzea;
    String izenLaburra;
    String helbidea;
    String postaKodea;
    Date Sortu_Data;

	public eraikina(int idEraikina, String izenLuzea, String izenLaburra, String helbidea, String postaKodea,
			Date sortu_Data) {
		super();
		this.idEraikina = idEraikina;
		this.izenLuzea = izenLuzea;
		this.izenLaburra = izenLaburra;
		this.helbidea = helbidea;
		this.postaKodea = postaKodea;
		Sortu_Data = sortu_Data;
	}

	public int getIdEraikina() {
		return idEraikina;
	}

	public void setIdEraikina(int idEraikina) {
		this.idEraikina = idEraikina;
	}

	public String getIzenLuzea() {
		return izenLuzea;
	}

	public void setIzenLuzea(String izenLuzea) {
		this.izenLuzea = izenLuzea;
	}

	public String getIzenLaburra() {
		return izenLaburra;
	}

	public void setIzenLaburra(String izenLaburra) {
		this.izenLaburra = izenLaburra;
	}

	public String getHelbidea() {
		return helbidea;
	}

	public void setHelbidea(String helbidea) {
		this.helbidea = helbidea;
	}

	public String getPostaKodea() {
		return postaKodea;
	}

	public void setPostaKodea(String postaKodea) {
		this.postaKodea = postaKodea;
	}

	public Date getSortu_Data() {
		return Sortu_Data;
	}

	public void setSortu_Data(Date sortu_Data) {
		Sortu_Data = sortu_Data;
	}

}


