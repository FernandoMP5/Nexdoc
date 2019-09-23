package co.edu.sena.Nexdoc.persistencia.dao;

import co.edu.sena.Nexdoc.persistencia.conexion.Conexion;
import co.edu.sena.Nexdoc.persistensia.vo.rolVO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class rolDAO {

 Connection con = null;
 PreparedStatement ps = null;
 ResultSet rs = null;
 ArrayList<rolVO> lista = new ArrayList<>();
 String sql = "";

 public rolDAO(Connection con) {
  this.con = con;
 }

 public List listarRol() throws Exception {
  sql = "SELECT * FROM rol WHERE idRol != 1";
  try {
   ps = con.prepareStatement(sql);
   rs = ps.executeQuery();
   while (rs.next()) {
    rolVO rolVO = new rolVO();
    rolVO.setIdRol(rs.getInt("idRol"));
    rolVO.setDescripcion(rs.getString("Descripcion"));
    lista.add(rolVO);
   }
   return lista;
  } catch (SQLException e) {
   throw new Exception("Error al listar los roles");
  } finally {
   Conexion.cerrar(ps, rs);
  }
 }
}
