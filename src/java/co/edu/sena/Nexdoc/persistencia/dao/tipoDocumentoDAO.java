/** @author Sena */
package co.edu.sena.Nexdoc.persistencia.dao;

import co.edu.sena.Nexdoc.persistencia.conexion.Conexion;
import co.edu.sena.Nexdoc.persistencia.vo.tipoDocumentoVO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class tipoDocumentoDAO {

 Connection con;
 PreparedStatement ps;
 ResultSet rs;
 private String sql = "";
 private ArrayList<tipoDocumentoVO> lista = new ArrayList<>();

 public tipoDocumentoDAO(Connection con) {
  this.con = con;
 }

 public List listartipoDoc() throws Exception {
  sql = "SELECT * FROM tipodocumento";
  try {
   ps = con.prepareStatement(sql);
   rs = ps.executeQuery();
   while (rs.next()) {
    tipoDocumentoVO tipoDocumentoVO = new tipoDocumentoVO();
    tipoDocumentoVO.setIdtipoDocumento(rs.getInt("idtipoDocumento"));
    tipoDocumentoVO.setDescripcion(rs.getString("descripcion"));
    lista.add(tipoDocumentoVO);
   }
   return lista;
  } catch (SQLException e) {
   throw new Exception("Error al listar tipos de documento");
  } finally {
   Conexion.cerrar(ps, rs);
  }
 }

}//fin clase tipoDocumentoDAO
