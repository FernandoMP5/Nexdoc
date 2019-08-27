
package co.edu.sena.Nexdoc.persistensia.vo;


public class Persona {
    private String IdPersona;
    private String Nombre;
    private String Apellido;
    private String Correo;
    private int Telefono;
    private int TipoIdentificacion;
    private int IdDepartamento;
    private int IdMunicipio;
    private String Direccion;

    public Persona() {
    }

    public Persona(String IdPersona, String Nombre, String Apellido, String Correo, int Telefono, int TipoIdentificacion, int IdDepartamento, int IdMunicipio, String Direccion) {
        this.IdPersona = IdPersona;
        this.Nombre = Nombre;
        this.Apellido = Apellido;
        this.Correo = Correo;
        this.Telefono = Telefono;
        this.TipoIdentificacion = TipoIdentificacion;
        this.IdDepartamento = IdDepartamento;
        this.IdMunicipio = IdMunicipio;
        this.Direccion = Direccion;
    }

    public int getIdDepartamento() {
        return IdDepartamento;
    }

    public void setIdDepartamento(int IdDepartamento) {
        this.IdDepartamento = IdDepartamento;
    }

    public int getIdMunicipio() {
        return IdMunicipio;
    }

    public void setIdMunicipio(int IdMunicipio) {
        this.IdMunicipio = IdMunicipio;
    }
    
    public String getIdPersona() {
        return IdPersona;
    }

    public void setIdPersona(String IdPersona) {
        this.IdPersona = IdPersona;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getApellido() {
        return Apellido;
    }

    public void setApellido(String Apellido) {
        this.Apellido = Apellido;
    }

    public String getCorreo() {
        return Correo;
    }

    public void setCorreo(String Correo) {
        this.Correo = Correo;
    }

    public int getTelefono() {
        return Telefono;
    }

    public void setTelefono(int Telefona) {
        this.Telefono = Telefona;
    }

    public int getTipoIdentificacion() {
        return TipoIdentificacion;
    }

    public void setTipoIdentificacion(int TipoIdentificacion) {
        this.TipoIdentificacion = TipoIdentificacion;
    }

    public String getDireccion() {
        return Direccion;
    }

    public void setDireccion(String Direccion) {
        this.Direccion = Direccion;
    }
    
}   
