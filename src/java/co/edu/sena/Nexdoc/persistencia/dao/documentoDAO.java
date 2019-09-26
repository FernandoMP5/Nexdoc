/** @author Sena */
package co.edu.sena.Nexdoc.persistencia.dao;

import co.edu.sena.Nexdoc.persistencia.conexion.Conexion;
import co.edu.sena.Nexdoc.persistencia.vo.documentoVO;
import co.edu.sena.Nexdoc.persistencia.vo.personaVO;
import co.edu.sena.Nexdoc.persistencia.vo.oficinaVO;
import co.edu.sena.Nexdoc.persistencia.vo.prioridadVO;
import co.edu.sena.Nexdoc.persistencia.vo.tipoDocumentoVO;
import co.edu.sena.Nexdoc.persistencia.vo.usuarioVO;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpSession;

public class documentoDAO {

 Connection con;
 PreparedStatement ps;
 ResultSet rs;
 private String sql = "";
 private final ArrayList<documentoVO> lista = new ArrayList<>();


 public documentoDAO(Connection con) {
  this.con = con;
 }

 public List recibidos(String idDestinatario) throws Exception {
  sql = "SELECT CONCAT(p.nombre,' ',p.apellido)nombre,d.idDocumento,d.visualizaciones,d.fechaRadicacion,r.descripcion,o.nombreOficina,t.descripcion FROM documento d INNER JOIN persona p ON d.`idRemitente`=p.`numeroIdentificacion` INNER JOIN oficina o ON d.`idOficina`=o.idOficina INNER JOIN prioridad r ON d.idPrioridad=r.idPrioridad INNER JOIN tipoDocumento t ON d.`idtipoDocumento`=t.`idtipoDocumento` WHERE idDestinatario=" + idDestinatario;
  try {
   ps = con.prepareStatement(sql);
   rs = ps.executeQuery();
   while (rs.next()) {
    documentoVO documentoVO = new documentoVO();
    personaVO personaVO = new personaVO();
    oficinaVO oficinaVO = new oficinaVO();
    tipoDocumentoVO tipoDocumentoVO = new tipoDocumentoVO();
    prioridadVO prioridadVO = new prioridadVO();
    documentoVO.setIdDocumento(rs.getInt("d.idDocumento"));
    documentoVO.setVisualizaciones(rs.getInt("d.visualizaciones"));
    documentoVO.setFechaRadicacion(rs.getDate("d.fechaRadicacion"));

    personaVO.setNombre(rs.getString("nombre"));
    documentoVO.setIdRemitente(personaVO);

    prioridadVO.setDescripcion(rs.getString("r.descripcion"));
    documentoVO.setIdPrioridad(prioridadVO);

    oficinaVO.setNombreOficina(rs.getString("o.nombreOficina"));
    documentoVO.setIdOficina(oficinaVO);

    tipoDocumentoVO.setDescripcion(rs.getString("t.descripcion"));
    documentoVO.setIdtipoDocumento(tipoDocumentoVO);
    lista.add(documentoVO);
   }
   return lista;
  } catch (SQLException e) {
   throw new Exception("Error al listar la tabla recibidos" + e);
  } finally {
   Conexion.cerrar(ps, rs);
  }
 }//fin recibidos

 public boolean radicarDocumento(documentoVO documentoVO,String idDestinatario,String idRemitente,String idRecepcionista) throws Exception {
  sql = "INSERT INTO documento(documentoPDF,visualizaciones,idRemitente,idDestinatario,idRecepcionista,idEstado,idPrioridad,fechaRadicacion,idOficina,idtipoDocumento) "
          + "VALUES(?,"//documentoPDF
          + "0,"//visualizaciones
          + "'" + idRemitente + "',"//idRemitente
          + "'" + idDestinatario + "',"//idDestinatario
          + "'" + idRecepcionista + "',"//idRecepcionista
          + "1,"//idEstado
          + "" + documentoVO.getIdPrioridad().getIdPrioridad() + ","//idPrioridad
          + "NOW(),"//fechaRadicacion
          + "" + documentoVO.getIdOficina().getIdOficina() + ","//idOficina
          + "" + documentoVO.getIdtipoDocumento().getIdtipoDocumento() + ")";//idtipoDocumento
  try {
   ps = con.prepareStatement(sql);
   ps.setBlob(1, documentoVO.getDocumentoPDF());
//      ps.setString(2, documentoVO.getIdRemitente());
//      ps.setInt(3, documentoVO.getIdPrioridad());
//      ps.setInt(4, documentoVO.getIdOficina());
//      ps.setInt(5, documentoVO.getIdtipoDocumento());
   ps.executeUpdate();
   return true;
  } catch (SQLException e) {
   throw new Exception("Error al radicar el documento" + e);
  } finally {
   Conexion.cerrar(ps, rs);
  }
 }//fin radicar

 public documentoVO listarDocumento(int idDocumento) throws Exception {
  documentoVO documentoVO = new documentoVO();
  personaVO personaVO = new personaVO();
  oficinaVO oficinaVO = new oficinaVO();
  tipoDocumentoVO tipoDocumentoVO = new tipoDocumentoVO();
  prioridadVO prioridadVO = new prioridadVO();
  sql = "SELECT CONCAT(p.nombre,' ',p.apellido)nombre,d.idDocumento,d.visualizaciones,d.fechaRadicacion,r.descripcion,o.nombreOficina,t.descripcion FROM documento d INNER JOIN persona p ON d.`idRemitente`=p.`numeroIdentificacion` INNER JOIN oficina o ON d.`idOficina`=o.idOficina INNER JOIN prioridad r ON d.idPrioridad=r.idPrioridad INNER JOIN tipoDocumento t ON d.`idtipoDocumento`=t.`idtipoDocumento` WHERE idDocumento=" + idDocumento;
  try {
   ps = con.prepareStatement(sql);
   rs = ps.executeQuery();
   while (rs.next()) {
    documentoVO.setIdDocumento(rs.getInt("d.idDocumento"));
    documentoVO.setVisualizaciones(rs.getInt("d.visualizaciones"));
    documentoVO.setFechaRadicacion(rs.getDate("d.fechaRadicacion"));
    personaVO.setNombre(rs.getString("nombre"));
    documentoVO.setIdRemitente(personaVO);
    prioridadVO.setDescripcion(rs.getString("r.descripcion"));
    documentoVO.setIdPrioridad(prioridadVO);
    oficinaVO.setNombreOficina(rs.getString("o.nombreOficina"));
    documentoVO.setIdOficina(oficinaVO);
    tipoDocumentoVO.setDescripcion(rs.getString("t.descripcion"));
    documentoVO.setIdtipoDocumento(tipoDocumentoVO);
   }
   return documentoVO;
  } catch (SQLException e) {
   throw new Exception("Error al mostrar el documento");
  } finally {
   Conexion.cerrar(ps, rs);
  }
 }

 public List enviados(String idRecepcionista) throws Exception {
  sql = "SELECT CONCAT(p.nombre,' ',p.apellido)nombre,d.idDocumento,d.visualizaciones,d.fechaRadicacion,r.descripcion,o.nombreOficina,t.descripcion FROM documento d INNER JOIN persona p ON d.`idDestinatario`=p.`numeroIdentificacion` INNER JOIN oficina o ON d.`idOficina`=o.idOficina INNER JOIN prioridad r ON d.idPrioridad=r.idPrioridad INNER JOIN tipoDocumento t ON d.`idtipoDocumento`=t.`idtipoDocumento` WHERE d.idRecepcionista=" + idRecepcionista;
  try {
   ps = con.prepareStatement(sql);
   rs = ps.executeQuery();
   while (rs.next()) {
    documentoVO documentoVO = new documentoVO();
    personaVO personaVO = new personaVO();
    oficinaVO oficinaVO = new oficinaVO();
    tipoDocumentoVO tipoDocumentoVO = new tipoDocumentoVO();
    prioridadVO prioridadVO = new prioridadVO();
    documentoVO.setIdDocumento(rs.getInt("d.idDocumento"));
    documentoVO.setVisualizaciones(rs.getInt("d.visualizaciones"));
    documentoVO.setFechaRadicacion(rs.getDate("d.fechaRadicacion"));

    personaVO.setNombre(rs.getString("nombre"));
    documentoVO.setIdDestinatario(personaVO);

    prioridadVO.setDescripcion(rs.getString("r.descripcion"));
    documentoVO.setIdPrioridad(prioridadVO);

    oficinaVO.setNombreOficina(rs.getString("o.nombreOficina"));
    documentoVO.setIdOficina(oficinaVO);

    tipoDocumentoVO.setDescripcion(rs.getString("t.descripcion"));
    documentoVO.setIdtipoDocumento(tipoDocumentoVO);
    lista.add(documentoVO);
   }
   return lista;
  } catch (SQLException e) {
   throw new Exception("Error al listar la tabla enviados" + e);
  } finally {
   Conexion.cerrar(ps, rs);
  }
 }//fin recibidos

}//fin clase documentoDAO
