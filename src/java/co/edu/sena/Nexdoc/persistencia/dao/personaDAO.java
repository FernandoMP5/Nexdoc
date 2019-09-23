package co.edu.sena.Nexdoc.persistencia.dao;

import co.edu.sena.Nexdoc.persistencia.conexion.Conexion;
import co.edu.sena.Nexdoc.persistencia.vo.personaVO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class personaDAO {

 Connection con;
 PreparedStatement ps;
 ResultSet rs;
 private String sql = "";
 private final ArrayList<personaVO> lista = new ArrayList<>();
 int r;

 public personaDAO(Connection con) {
  this.con = con;
 }

 public boolean registrarRemitente(personaVO personaVO) throws Exception {
  try {
   sql = "INSERT INTO persona(numeroIdentificacion,tipoIdentificacion,nombre,apellido,correo,telefonoFijo,telefonoCelular,direccion,rol) VALUES('" + personaVO.getNumeroIdentificacion() + "'," + personaVO.getTipoIdentificacion() + ",'" + personaVO.getNombre() + "','" + personaVO.getApellido() + "','" + personaVO.getCorreo() + "'," + personaVO.getTelefonoFijo() + "," + personaVO.getTelefonoCelular() + ",'" + personaVO.getDireccion() + "',1)";
   ps = con.prepareStatement(sql);
   ps.executeUpdate();
   return true;
  } catch (Exception e) {
   throw new Exception("Error al agregar al Remitente" + e);
  } finally {
   Conexion.cerrar(ps, rs);
  }
 }

 public boolean registrarFuncionario(personaVO personaVO) throws Exception {
  try {
   sql = "INSERT INTO persona(numeroIdentificacion,tipoIdentificacion,nombre,apellido,correo,telefonoFijo,telefonoCelular,direccion,rol,usuario,clave,oficina) VALUES('" + personaVO.getNumeroIdentificacion() + "'," + personaVO.getTipoIdentificacion() + ",'" + personaVO.getNombre() + "','" + personaVO.getApellido() + "','" + personaVO.getCorreo() + "'," + personaVO.getTelefonoFijo() + "," + personaVO.getTelefonoCelular() + ",'" + personaVO.getDireccion() + "'," + personaVO.getRol() + ",'" + personaVO.getUsuario() + "','" + personaVO.getNumeroIdentificacion() + "'," + personaVO.getOficina() + ")";
   ps = con.prepareStatement(sql);
   ps.executeUpdate();
   return true;
  } catch (Exception e) {
   throw new Exception("Error al agregar al Funcionario" + e);
  } finally {
   Conexion.cerrar(ps, rs);
  }
 }

 public boolean actualizarRemitente(String numeroIdentificacion, personaVO personaVO) throws Exception {
  try {
   sql = "UPDATE persona SET numeroIdentificacion = '?',tipoIdentifcicacion = ?,nombre = '?',apellido = '?',correo = '?',"
           + "telefonoFijo = ?,telefonoCelular = ?,direccion = '?' WHERE numeroIdentificacion=" + numeroIdentificacion;
   ps = con.prepareStatement(sql);
   ps.setString(1, personaVO.getNumeroIdentificacion());
   ps.setInt(2, personaVO.getTipoIdentificacion());
   ps.setString(3, personaVO.getNombre());
   ps.setString(4, personaVO.getApellido());
   ps.setString(5, personaVO.getCorreo());
   ps.setDouble(6, personaVO.getTelefonoFijo());
   ps.setDouble(7, personaVO.getTelefonoCelular());
   ps.setString(8, personaVO.getDireccion());
   ps.executeUpdate();
   return true;
  } catch (Exception e) {
   throw new Exception("Error al actualizar al Remitente" + e);
  } finally {
   Conexion.cerrar(ps, rs);
  }
 }

 public boolean actualizarFuncionario(String numeroIdentificacion, personaVO personaVO) throws Exception {
  try {
   sql = "UPDATE persona SET numeroIdentificacion = '?',tipoIdentifcicacion = ?,nombre = '?',apellido = '?',correo = '?',"
           + "telefonoFijo = ?,telefonoCelular = ?,direccion = '?',rol = ?,usuario = '?',clave = '?',"
           + "oficina = ? WHERE numeroIdentificacion=" + numeroIdentificacion;
   ps = con.prepareStatement(sql);
   ps.setString(1, personaVO.getNumeroIdentificacion());
   ps.setInt(2, personaVO.getTipoIdentificacion());
   ps.setString(3, personaVO.getNombre());
   ps.setString(4, personaVO.getApellido());
   ps.setString(5, personaVO.getCorreo());
   ps.setDouble(6, personaVO.getTelefonoFijo());
   ps.setDouble(7, personaVO.getTelefonoCelular());
   ps.setString(8, personaVO.getDireccion());
   ps.setInt(9, personaVO.getRol());
   ps.setString(10, personaVO.getUsuario());
   ps.setString(11, personaVO.getClave());
   ps.setInt(12, personaVO.getOficina());
   ps.executeUpdate();
   return true;
  } catch (Exception e) {
   throw new Exception("Error al actualizar al Funcionario" + e);
  } finally {
   Conexion.cerrar(ps, rs);
  }
 }

 public List listarRemitentes() throws Exception {
  sql = "SELECT * FROM persona WHERE rol=1";
  try {
   ps = con.prepareStatement(sql);
   rs = ps.executeQuery();
   while (rs.next()) {
    personaVO personaVO = new personaVO();
    personaVO.setNombre(rs.getString("nombre"));
    personaVO.setApellido(rs.getString("apellido"));
    personaVO.setNumeroIdentificacion(rs.getString("numeroIdentificacion"));
    personaVO.setCorreo(rs.getString("correo"));
    personaVO.setDireccion(rs.getString("direccion"));
    personaVO.setTelefonoFijo(rs.getDouble("telefonoFijo"));
    personaVO.setTelefonoCelular(rs.getDouble("telefonoCelular"));
    personaVO.setTipoIdentificacion(rs.getInt("tipoIdentificacion"));
    lista.add(personaVO);
   }
   return lista;
  } catch (SQLException e) {
   throw new Exception("Error al listar los remitentes" + e);
  } finally {
   Conexion.cerrar(ps, rs);
  }
 }

 public List listarFuncionarios() throws Exception {
  sql = "SELECT CONCAT(P.nombre,' ',P.apellido)nombre,P.numeroIdentificacion,P.direccion,P.telefonoFijo,P.telefonoCelular,P.correo,R.descripcion,O.nombreOficina FROM persona P "
          + "INNER JOIN rol R ON P.rol=R.idRol INNER JOIN oficina O ON O.idOficina=P.oficina "
          + "WHERE P.rol > 1";
  try {
   ps = con.prepareStatement(sql);
   rs = ps.executeQuery();
   while (rs.next()) {
    personaVO personaVO = new personaVO();
    personaVO.setNombre(rs.getString("nombre"));
    personaVO.setNumeroIdentificacion(rs.getString("numeroIdentificacion"));
    personaVO.setCorreo(rs.getString("correo"));
    personaVO.setDireccion(rs.getString("direccion"));
    personaVO.setTelefonoFijo(rs.getDouble("telefonoFijo"));
    personaVO.setTelefonoCelular(rs.getDouble("telefonoCelular"));
    lista.add(personaVO);
   }
   return lista;
  } catch (SQLException e) {
   throw new Exception("Error al listar los funcionarios " + e);
  } finally {
   Conexion.cerrar(ps, rs);
  }
 }

 public List listarFuncionariosPorOficina(int idOficina) throws Exception {
  sql = "SELECT CONCAT(nombre,' ',apellido)nombre,numeroIdentificacion "
          + "FROM persona WHERE rol > 1 AND oficina=" + idOficina;
  try {
   ps = con.prepareStatement(sql);
   rs = ps.executeQuery();
   while (rs.next()) {
    personaVO personaVO = new personaVO();
    personaVO.setNombre(rs.getString("nombre"));
    personaVO.setNumeroIdentificacion(rs.getString("numeroIdentificacion"));
    lista.add(personaVO);
   }
   return lista;
  } catch (SQLException e) {
   throw new Exception("Error al listar los funcionarios de la oficina " + e);
  } finally {
   Conexion.cerrar(ps, rs);
  }
 }

 public List listar1Persona(String id) throws Exception {
  personaVO persona = new personaVO();
  sql = "SELECT * FROM persona WHERE numeroIdentificacion='" + id + "'";
  try {
   ps = con.prepareStatement(sql);
   rs = ps.executeQuery();
   while (rs.next()) {
    persona.setNombre(rs.getString("nombre"));
    persona.setApellido(rs.getString("apellido"));
    persona.setNumeroIdentificacion(rs.getString("numeroIdentificacion"));
    persona.setCorreo(rs.getString("correo"));
    persona.setDireccion(rs.getString("direccion"));
    persona.setTelefonoFijo(rs.getDouble("telefonoFijo"));
    persona.setTelefonoCelular(rs.getDouble("telefonoCelular"));
    persona.setTipoIdentificacion(rs.getInt("tipoIdentificacion"));
    persona.setRol(rs.getInt("rol"));
    persona.setOficina(rs.getInt("oficina"));
    lista.add(persona);
   }
   return lista;
  } catch (SQLException e) {
   throw new Exception("Error al listar a un persona " + e);
  } finally {
   Conexion.cerrar(ps, rs);
  }
 }

}//fin clase personaDAO
