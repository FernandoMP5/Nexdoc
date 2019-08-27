
package co.edu.sena.Nexdoc.persistensia.vo;


public class Cargo {
    private int IdCargo;
    private String Descripcion;

    public Cargo() {
    }

    public Cargo(int IdCargo, String Descripcion) {
        this.IdCargo = IdCargo;
        this.Descripcion = Descripcion;
    }

    public int getIdCargo() {
        return IdCargo;
    }

    public void setIdCargo(int IdCargo) {
        this.IdCargo = IdCargo;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }
    
}
