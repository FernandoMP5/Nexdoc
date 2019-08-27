
package co.edu.sena.Nexdoc.persistensia.vo;


public class Municipio {
    private int IdMunicipio;
    private String Nombre_Municipio;
    private int IdDepartamento;

    public Municipio(int IdMunicipio, String Nombre_Municipio, int IdDepartamento) {
        this.IdMunicipio = IdMunicipio;
        this.Nombre_Municipio = Nombre_Municipio;
        this.IdDepartamento = IdDepartamento;
    }

    public Municipio() {
    }

    public int getIdMunicipio() {
        return IdMunicipio;
    }

    public void setIdMunicipio(int IdMunicipio) {
        this.IdMunicipio = IdMunicipio;
    }

    public String getNombre_Municipio() {
        return Nombre_Municipio;
    }

    public void setNombre_Municipio(String Nombre_Municipio) {
        this.Nombre_Municipio = Nombre_Municipio;
    }

    public int getIdDepartamento() {
        return IdDepartamento;
    }

    public void setIdDepartamento(int IdDepartamento) {
        this.IdDepartamento = IdDepartamento;
    }
    
}
