package co.edu.sena.Nexdoc.persistencia.dao;

import co.edu.sena.Nexdoc.persistencia.conexion.Conexion;
import co.edu.sena.Nexdoc.persistencia.vo.personaVO;
import co.edu.sena.Nexdoc.persistencia.vo.usuarioVO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class usuarioDAO {

 Connection con;
 PreparedStatement ps;
 ResultSet rs;
 private String sql = "";
 private final ArrayList<personaVO> lista = new ArrayList<>();
 int r;

 public usuarioDAO(Connection con) {
  this.con = con;
 } 

 public int validar(usuarioVO usuarioVO) throws Exception {
  r = 0;
  sql = "SELECT * FROM persona WHERE usuario='" + usuarioVO.getUsuario() + "' AND clave='" + usuarioVO.getClave() + "'";
  try {
   ps = con.prepareStatement(sql);
   rs = ps.executeQuery();
   while (rs.absolute(1)) {
    ++r;
    usuarioVO.setNumeroIdentificacion(rs.getString("numeroIdentificacion"));
    usuarioVO.setTipoIdentificacion(rs.getInt("tipoIdentificacion"));
    usuarioVO.setNombre(rs.getString("nombre"));
    usuarioVO.setApellido(rs.getString("apellido"));
    usuarioVO.setCorreo(rs.getString("correo"));
    usuarioVO.setTelefonoFijo(rs.getDouble("telefonoFijo"));
    usuarioVO.setTelefonoCelular(rs.getDouble("telefonoCelular"));
    usuarioVO.setDireccion(rs.getString("direccion"));
    usuarioVO.setRol(rs.getInt("rol"));
    usuarioVO.setUsuario(rs.getString("usuario"));
    usuarioVO.setClave(rs.getString("clave"));
    usuarioVO.setOficina(rs.getInt("oficina"));
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
}
