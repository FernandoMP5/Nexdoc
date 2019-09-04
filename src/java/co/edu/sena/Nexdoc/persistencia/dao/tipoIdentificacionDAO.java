package co.edu.sena.Nexdoc.persistencia.dao;

import co.edu.sena.Nexdoc.persistencia.conexion.Conexion;
import co.edu.sena.Nexdoc.persistensia.vo.tipoIdentificacionVO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class tipoIdentificacionDAO {

 Connection con;
 PreparedStatement ps;
 ResultSet rs;
 String sql = "";
 ArrayList<tipoIdentificacionVO> lista = new ArrayList<>();

 public tipoIdentificacionDAO(Connection con) {
  this.con = con;
 }

 public List listartipoIdentificacion() throws Exception {
  sql = "SELECT * FROM tipoIdentificacion";
  try {
   ps = con.prepareStatement(sql);
   rs = ps.executeQuery();
   while (rs.next()) {
    tipoIdentificacionVO tipoIdentificacionVO = new tipoIdentificacionVO();
    tipoIdentificacionVO.setIdtipoIdentificacion(rs.getInt("idtipoIdentificacion"));
    tipoIdentificacionVO.setDescripcion(rs.getString("descripcion"));
    lista.add(tipoIdentificacionVO);
   }
   return lista;
  } catch (SQLException e) {
   throw new Exception("Error al listar tipos de Identificacion");
  } finally {
   Conexion.cerrar(ps, rs);
  }
 }

}
