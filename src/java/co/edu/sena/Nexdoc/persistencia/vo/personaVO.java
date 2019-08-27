/** @author Sena*/
package co.edu.sena.Nexdoc.persistensia.vo;


public class personaVO {

    private String numeroIdentificacion;
    private int tipoIdentificacion;
    private String nombre;
    private String apellido;
    private String correo;
    private double telefonoFijo;
    private double telefonoCelular;
    private String direccion;
    private int rol;

    public personaVO() {
    }

    public String getNumeroIdentificacion() {
        return numeroIdentificacion;
    }

    public void setNumeroIdentificacion(String numeroIdentificacion) {
        this.numeroIdentificacion = numeroIdentificacion;
    }

    public int getTipoIdentificacion() {
        return tipoIdentificacion;
    }

    public void setTipoIdentificacion(int tipoIdentificacion) {
        this.tipoIdentificacion = tipoIdentificacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public double getTelefonoFijo() {
        return telefonoFijo;
    }

    public void setTelefonoFijo(double telefonoFijo) {
        this.telefonoFijo = telefonoFijo;
    }

    public double getTelefonoCelular() {
        return telefonoCelular;
    }

    public void setTelefonoCelular(double telefonoCelular) {
        this.telefonoCelular = telefonoCelular;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getRol() {
        return rol;
    }

    public void setRol(int rol) {
        this.rol = rol;
    }
    
}//fin clase personaVO
