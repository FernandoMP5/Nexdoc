package co.edu.sena.Nexdoc.negocio;

import co.edu.sena.Nexdoc.persistencia.conexion.Conexion;
import co.edu.sena.Nexdoc.persistencia.dao.personaDAO;
import co.edu.sena.Nexdoc.persistencia.vo.personaVO;
import com.google.gson.Gson;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ControladorPersona extends HttpServlet {

 Connection con;
 Conexion cn = new Conexion();
 personaVO personaVO = new personaVO();
 personaDAO personaDAO = new personaDAO(con);
 Gson json = new Gson();
 String gson;
 PrintWriter out;

 public ControladorPersona() throws Exception {
  this.personaDAO = new personaDAO(cn.conectar());
 }

 protected void processRequest(HttpServletRequest request, HttpServletResponse response)
         throws ServletException, IOException {
  String path = request.getParameter("path");
  switch (path) {
   case "/iniciarSesion":
    iniciarSesion(request, response);
    break;
   case "/registrarRemitente":
    registrarRemitente(request, response);
    break;
   case "/registrarFuncionario":
    registrarFuncionario(request, response);
    break;
   case "/actualizarRemitente":
    actualizarRemitente(request, response);
    break;
   case "/actualizarFuncionario":
    actualizarFuncionario(request, response);
    break;
   default:
    throw new AssertionError();
  }
  out = response.getWriter();
  out.print(gson);
  out.flush();
 }

 public void iniciarSesion(HttpServletRequest request, HttpServletResponse response)
         throws ServletException, IOException {
  int resultado;
  String usuario = request.getParameter("usuario");
  String contraseña = request.getParameter("clave");
  personaVO.setUsuario(usuario);
  personaVO.setClave(contraseña);
  try {
   resultado = personaDAO.validar(personaVO);
   if (resultado == 1) {
    HttpSession misession = request.getSession(true);
    misession.setAttribute("personaVO", personaVO);
    int rol = personaVO.getRol();
    gson = json.toJson(rol);
   } else {
    gson = json.toJson(resultado);
   }
  } catch (Exception ex) {
   Logger.getLogger(ControladorPersona.class.getName()).log(Level.SEVERE, null, ex);
  }
 }

 public void registrarRemitente(HttpServletRequest request, HttpServletResponse response)
         throws ServletException, IOException {
  boolean resultado = false;
  String nombre = request.getParameter("txtnombre");
  String apellido = request.getParameter("txtapellido");
  int tipoIdentificacion = Integer.parseInt(request.getParameter("cbotipoidentificacion"));
  String numeroIdentificacion = request.getParameter("txtdocumento");
  String correo = request.getParameter("txtcorreo");
  double telefonoFijo = Integer.parseInt(request.getParameter("txttelefonoFijo"));
  double telefonoCelular = Integer.parseInt(request.getParameter("txttelefonoCelular"));
  String direccion = request.getParameter("txtdireccion");
  personaVO.setNumeroIdentificacion(numeroIdentificacion);
  personaVO.setTipoIdentificacion(tipoIdentificacion);
  personaVO.setNombre(nombre);
  personaVO.setApellido(apellido);
  personaVO.setCorreo(correo);
  personaVO.setTelefonoFijo(telefonoFijo);
  personaVO.setTelefonoCelular(telefonoCelular);
  personaVO.setDireccion(direccion);
  try {
   resultado = personaDAO.registrarRemitente(personaVO);
   gson = json.toJson(resultado);
  } catch (Exception ex) {
   Logger.getLogger(ControladorPersona.class.getName()).log(Level.SEVERE, null, ex);
  }
 }

 public void registrarFuncionario(HttpServletRequest request, HttpServletResponse response)
         throws ServletException, IOException {
  boolean resultado = false;
  String nombre = request.getParameter("txtnombre");
  String apellido = request.getParameter("txtapellido");
  int tipoIdentificacion = Integer.parseInt(request.getParameter("cbotipoidentificacion"));
  String numeroIdentificacion = request.getParameter("txtdocumento");
  String correo = request.getParameter("txtcorreo");
  double telefonoFijo = Integer.parseInt(request.getParameter("txttelefonoFijo"));
  double telefonoCelular = Integer.parseInt(request.getParameter("txttelefonoCelular"));
  String direccion = request.getParameter("txtdireccion");
  int rol = Integer.parseInt(request.getParameter("cbocargo"));
  int idOficina = Integer.parseInt(request.getParameter("cbooficina"));
  String usuario = request.getParameter("txtusuario");
  String clave = request.getParameter("txtclave");
  personaVO.setNumeroIdentificacion(numeroIdentificacion);
  personaVO.setTipoIdentificacion(tipoIdentificacion);
  personaVO.setNombre(nombre);
  personaVO.setApellido(apellido);
  personaVO.setCorreo(correo);
  personaVO.setTelefonoFijo(telefonoFijo);
  personaVO.setTelefonoCelular(telefonoCelular);
  personaVO.setDireccion(direccion);
  personaVO.setRol(rol);
  personaVO.setUsuario(usuario);
  personaVO.setClave(clave);
  personaVO.setOficina(idOficina);
  try {
   resultado = personaDAO.registrarFuncionario(personaVO);
   gson = json.toJson(resultado);
  } catch (Exception ex) {
   Logger.getLogger(ControladorPersona.class.getName()).log(Level.SEVERE, null, ex);
  }
 }

 public void actualizarFuncionario(HttpServletRequest request, HttpServletResponse response)
         throws ServletException, IOException {
  boolean resultado = false;
  String nombre = request.getParameter("txtnombre");
  String apellido = request.getParameter("txtapellido");
  int tipoIdentificacion = Integer.parseInt(request.getParameter("cbotipoidentificacion"));
  String numeroIdentificacion = request.getParameter("txtdocumento");
  String correo = request.getParameter("txtcorreo");
  double telefonoFijo = Integer.parseInt(request.getParameter("txttelefonoFijo"));
  double telefonoCelular = Integer.parseInt(request.getParameter("txttelefonoCelular"));
  String direccion = request.getParameter("txtdireccion");
  int rol = Integer.parseInt(request.getParameter("cbocargo"));
  int idOficina = Integer.parseInt(request.getParameter("cbooficina"));
  String usuario = request.getParameter("txtusuario");
  String clave = request.getParameter("txtclave");
  personaVO.setNumeroIdentificacion(numeroIdentificacion);
  personaVO.setTipoIdentificacion(tipoIdentificacion);
  personaVO.setNombre(nombre);
  personaVO.setApellido(apellido);
  personaVO.setCorreo(correo);
  personaVO.setTelefonoFijo(telefonoFijo);
  personaVO.setTelefonoCelular(telefonoCelular);
  personaVO.setDireccion(direccion);
  personaVO.setRol(rol);
  personaVO.setUsuario(usuario);
  personaVO.setClave(clave);
  personaVO.setOficina(idOficina);
  try {
   personaDAO.actualizarFuncionario(numeroIdentificacion, personaVO);
   gson = json.toJson(resultado);
  } catch (Exception ex) {
   Logger.getLogger(ControladorPersona.class.getName()).log(Level.SEVERE, null, ex);
  }
 }

 public void actualizarRemitente(HttpServletRequest request, HttpServletResponse response)
         throws ServletException, IOException {
  boolean resultado = false;
  String nombre = request.getParameter("txtnombre");
  String apellido = request.getParameter("txtapellido");
  int tipoIdentificacion = Integer.parseInt(request.getParameter("cbotipoidentificacion"));
  String numeroIdentificacion = request.getParameter("txtdocumento");
  String correo = request.getParameter("txtcorreo");
  double telefonoFijo = Integer.parseInt(request.getParameter("txttelefonoFijo"));
  double telefonoCelular = Integer.parseInt(request.getParameter("txttelefonoCelular"));
  String direccion = request.getParameter("txtdireccion");
  personaVO.setNumeroIdentificacion(numeroIdentificacion);
  personaVO.setTipoIdentificacion(tipoIdentificacion);
  personaVO.setNombre(nombre);
  personaVO.setApellido(apellido);
  personaVO.setCorreo(correo);
  personaVO.setTelefonoFijo(telefonoFijo);
  personaVO.setTelefonoCelular(telefonoCelular);
  personaVO.setDireccion(direccion);
  try {
   personaDAO.actualizarRemitente(numeroIdentificacion, personaVO);
   gson = json.toJson(resultado);
  } catch (Exception ex) {
   Logger.getLogger(ControladorPersona.class.getName()).log(Level.SEVERE, null, ex);
  }
 }

 @Override
 protected void doGet(HttpServletRequest request, HttpServletResponse response)
         throws ServletException, IOException {
  processRequest(request, response);
 }

 @Override
 protected void doPost(HttpServletRequest request, HttpServletResponse response)
         throws ServletException, IOException {
  processRequest(request, response);
 }

 @Override
 public String getServletInfo() {
  return "Short description";
 }

}
