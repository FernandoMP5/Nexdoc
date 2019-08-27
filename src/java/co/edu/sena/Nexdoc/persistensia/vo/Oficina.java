
package co.edu.sena.Nexdoc.persistensia.vo;


public class Oficina {
    int IdOficina;
    String Nombre;
    String TelefonoExtencion;
    String IdSede;

    public Oficina(int IdOficina, String Nombre, String TelefonoExtencion, String IdSede) {
        this.IdOficina = IdOficina;
        this.Nombre = Nombre;
        this.TelefonoExtencion = TelefonoExtencion;
        this.IdSede = IdSede;
    }

    public Oficina() {
    }

    public int getIdOficina() {
        return IdOficina;
    }

    public void setIdOficina(int IdOficina) {
        this.IdOficina = IdOficina;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getTelefonoExtencion() {
        return TelefonoExtencion;
    }

    public void setTelefonoExtencion(String TelefonoExtencion) {
        this.TelefonoExtencion = TelefonoExtencion;
    }

    public String getIdSede() {
        return IdSede;
    }

    public void setIdSede(String IdSede) {
        this.IdSede = IdSede;
    }
}
