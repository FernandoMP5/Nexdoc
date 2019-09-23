/** @author Sena */
package co.edu.sena.Nexdoc.persistencia.dao;

import co.edu.sena.Nexdoc.persistencia.conexion.Conexion;
import co.edu.sena.Nexdoc.persistencia.vo.historialVO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class historialDAO {

  Connection con;
  PreparedStatement ps;
  ResultSet rs;
  private String sql = "";
  private final ArrayList<historialVO> lista = new ArrayList<>();

  public historialDAO(Connection con) {
    this.con = con;
  }

  public boolean agregarHistorial(historialVO historialVO) throws Exception {
    sql = "INSERT INTO historial(`idHistoria`,`idDocumento`,`fechaHistoria`,`respuestaPDF`,`respuestaComen`,`idDestinatario`) VALUES"
            + "(" + historialVO.getIdHistotia() + ","
            + "" + historialVO.getIdDocumento() + ","
            + "NOW()," + historialVO.getRespuestaPDF() + ","
            + "'" + historialVO.getRespuestaComen() + "',"
            + "" + historialVO.getIdDestinatario() + ")";
    try {
      ps = con.prepareStatement(sql);
      ps.executeUpdate();
      return false;
    } catch (SQLException e) {
      throw new Exception("Error al agregar respuesta");
    }
  }

  public List listarHistorial(int idDocumento) throws Exception {
    sql = "SELECT * FROM historial WHERE idDocumento = " + idDocumento;
    try {
      ps = con.prepareStatement(sql);
      rs = ps.executeQuery();
      while (rs.next()) {
        historialVO historial = new historialVO();
        historial.setFechaHistoria(rs.getDate("fechaHistoria"));
        historial.setRespuestaComen(rs.getString("respuestaComen"));
//        historial.setIdDestinatario(rs.getInt("idDestinatario"));
        lista.add(historial);
      }
      return lista;
    } catch (Exception e) {
      throw new Exception("Error al listar el historial del documento" + e);
    } finally {
      Conexion.cerrar(ps, rs);
    }
  }

}//fin clase historialDAO
