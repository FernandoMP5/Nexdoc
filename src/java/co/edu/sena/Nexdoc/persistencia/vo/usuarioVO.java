package co.edu.sena.Nexdoc.persistencia.vo;

public class usuarioVO {

 private String numeroIdentificacion;
 private int tipoIdentificacion;
 private String nombre;
 private String apellido;
 private String correo;
 private Double telefonoFijo;
 private Double telefonoCelular;
 private String direccion;
 private int rol;
 private String usuario;
 private String clave;
 private int oficina;

 public usuarioVO() {
 }

 public usuarioVO(String numeroIdentificacion, int tipoIdentificacion, String nombre, String apellido, String correo, Double telefonoFijo, Double telefonoCelular, String direccion, int rol, String usuario, String clave, int oficina) {
  this.numeroIdentificacion = numeroIdentificacion;
  this.tipoIdentificacion = tipoIdentificacion;
  this.nombre = nombre;
  this.apellido = apellido;
  this.correo = correo;
  this.telefonoFijo = telefonoFijo;
  this.telefonoCelular = telefonoCelular;
  this.direccion = direccion;
  this.rol = rol;
  this.usuario = usuario;
  this.clave = clave;
  this.oficina = oficina;
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

 public Double getTelefonoFijo() {
  return telefonoFijo;
 }

 public void setTelefonoFijo(Double telefonoFijo) {
  this.telefonoFijo = telefonoFijo;
 }

 public Double getTelefonoCelular() {
  return telefonoCelular;
 }

 public void setTelefonoCelular(Double telefonoCelular) {
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

 public String getUsuario() {
  return usuario;
 }

 public void setUsuario(String usuario) {
  this.usuario = usuario;
 }

 public String getClave() {
  return clave;
 }

 public void setClave(String clave) {
  this.clave = clave;
 }

 public int getOficina() {
  return oficina;
 }

 public void setOficina(int oficina) {
  this.oficina = oficina;
 }
}
