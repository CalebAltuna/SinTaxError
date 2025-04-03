// Creado el 19/06/20
package modelo;

public class eraikina {
    int idEraikina;
    String izenLuzea;
    String izenLaburra;
    String helbidea;
    String postaKodea;
//konstruktorea
    public eraikina(int idEraikina, String izenLuzea, String izenLaburra, String helbidea, String postaKodea) {
        this.idEraikina = idEraikina;
        this.izenLuzea = izenLuzea;
        this.izenLaburra = izenLaburra;
        this.helbidea = helbidea;
        this.postaKodea = postaKodea;
    }
    //getters eta setters
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
}


