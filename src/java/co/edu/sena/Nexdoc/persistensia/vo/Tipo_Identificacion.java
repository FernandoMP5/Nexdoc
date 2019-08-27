
package co.edu.sena.Nexdoc.persistensia.vo;


public class Tipo_Identificacion {
    private int IdTipoIdentificacion;
    private String Descripcion;

    public Tipo_Identificacion() {
    }

    public Tipo_Identificacion(int IdTipoIdentificacion, String Descripcion) {
        this.IdTipoIdentificacion = IdTipoIdentificacion;
        this.Descripcion = Descripcion;
    }

    public int getIdTipoIdentificacion() {
        return IdTipoIdentificacion;
    }

    public void setIdTipoIdentificacion(int IdTipoIdentificacion) {
        this.IdTipoIdentificacion = IdTipoIdentificacion;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }
    
}
