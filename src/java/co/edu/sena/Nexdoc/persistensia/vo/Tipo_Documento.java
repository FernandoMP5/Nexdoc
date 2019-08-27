package co.edu.sena.Nexdoc.persistensia.vo;

public class Tipo_Documento {
    int IdTipo_Documento;
    String Descripcion;

    public Tipo_Documento(int IdTipo_Documento, String Descripcion) {
        this.IdTipo_Documento = IdTipo_Documento;
        this.Descripcion = Descripcion;
    }

    public Tipo_Documento() {
    }

    public int getIdTipo_Documento() {
        return IdTipo_Documento;
    }

    public void setIdTipo_Documento(int IdTipo_Documento) {
        this.IdTipo_Documento = IdTipo_Documento;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }

}
