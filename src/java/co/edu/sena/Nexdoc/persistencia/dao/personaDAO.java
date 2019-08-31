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

  public int validar(personaVO personaVO) throws Exception {
    r = 0;
    sql = "SELECT * FROM persona WHERE usuario='" + personaVO.getUsuario() + "' AND clave='" + personaVO.getClave() + "'";
    try {
      ps = con.prepareStatement(sql);
      rs = ps.executeQuery();
      while (rs.absolute(1)) {
        ++r;
        personaVO.setNumeroIdentificacion(rs.getString("numeroIdentificacion"));
        personaVO.setTipoIdentificacion(rs.getInt("tipoIdentificacion"));
        personaVO.setNombre(rs.getString("nombre"));
        personaVO.setApellido(rs.getString("apellido"));
        personaVO.setCorreo(rs.getString("correo"));
        personaVO.setTelefonoFijo(rs.getDouble("telefonoFijo"));
        personaVO.setTelefonoCelular(rs.getDouble("telefonoCelular"));
        personaVO.setDireccion(rs.getString("direccion"));
        personaVO.setRol(rs.getInt("rol"));
        personaVO.setUsuario(rs.getString("usuario"));
        personaVO.setClave(rs.getString("clave"));
        personaVO.setOficina(rs.getInt("oficina"));
        if (r == 1) {
          break;
        }
      }
      if (r == 1) {
        return 1;
      } else {
        return 0;
      }
    } catch (SQLException e) {
      throw new Exception("Error al validar usuario" + e);
    } finally {
      Conexion.cerrar(ps, rs);
    }
  }

  public boolean agregarPersona(personaVO personaVO) throws Exception {
    try {
      sql = "INSERT INTO persona(numeroIdentificacion,tipoIdentifcicacion,nombre,apellido,correo,telefonoFijo,telefonoCelular,direccion,rol,usuario,clave,oficina) "
              + "VALUES('?',?,'?','?','?',?,?,'?',?,'?','?',?)";
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
      return false;
    } catch (Exception e) {
      throw new Exception("Error al agregar a la persona" + e);
    } finally {
      Conexion.cerrar(ps, rs);
    }
  }

  public boolean actualizarPersona(String numeroIdentificacion, personaVO personaVO) throws Exception {
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
      return false;
    } catch (Exception e) {
      throw new Exception("Error al actualizar a la persona" + e);
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
    }
  }
}//fin clase personaDAO
