
package co.edu.sena.Nexdoc.persistensia.vo;


public class Sede {
    private int IdSede;
    private String Nombre;
    private int IdMunicipio;

    public Sede() {
    }

    public Sede(int IdSede, String Nombre, int IdMunicipio) {
        this.IdSede = IdSede;
        this.Nombre = Nombre;
        this.IdMunicipio = IdMunicipio;
    }

    public int getIdSede() {
        return IdSede;
    }

    public void setIdSede(int IdSede) {
        this.IdSede = IdSede;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public int getIdMunicipio() {
        return IdMunicipio;
    }

    public void setIdMunicipio(int IdMunicipio) {
        this.IdMunicipio = IdMunicipio;
    }
    
}
