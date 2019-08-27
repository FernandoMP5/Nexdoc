
package co.edu.sena.Nexdoc.persistensia.vo;


public class Funcionario {

    int Id;
    String Usuario;
    String Contraseña;
    String IdCargo;
    String IdPersona;
    String IdOficina;

    public Funcionario(int Id, String Usuario, String Contraseña, String IdCargo, String IdPersona, String IdOficina) {
        this.Id = Id;
        this.Usuario = Usuario;
        this.Contraseña = Contraseña;
        this.IdCargo = IdCargo;
        this.IdPersona = IdPersona;
        this.IdOficina = IdOficina;
    }

    public Funcionario() {
    }

    public String getIdCargo() {
        return IdCargo;
    }

    public void setIdCargo(String IdCargo) {
        this.IdCargo = IdCargo;
    }

    public String getIdPersona() {
        return IdPersona;
    }

    public void setIdPersona(String IdPersona) {
        this.IdPersona = IdPersona;
    }

    public String getIdOficina() {
        return IdOficina;
    }

    public void setIdOficina(String IdOficina) {
        this.IdOficina = IdOficina;
    }
    
    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public String getUsuario() {
        return Usuario;
    }

    public void setUsuario(String Usuario) {
        this.Usuario = Usuario;
    }

    public String getContraseña() {
        return Contraseña;
    }

    public void setContraseña(String Contraseña) {
        this.Contraseña = Contraseña;
    }
}
