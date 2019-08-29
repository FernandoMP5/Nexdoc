/** @author Sena */
package co.edu.sena.Nexdoc.persistencia.dao;

import co.edu.sena.Nexdoc.persistencia.conexion.Conexion;
import co.edu.sena.Nexdoc.persistencia.vo.documentoVO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class documentoDAO {

    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    private String sql = "";
    private final ArrayList<documentoVO> lista = new ArrayList<>();

    public documentoDAO(Connection con) {
        this.con = con;
    }

    public List recibidos(int idDestinatario) throws Exception {
        sql = "SELECT * FROM documentos WHERE idDestinatario=" + idDestinatario;
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                documentoVO documentoVO = new documentoVO();
                documentoVO.setIdDocumento(rs.getInt("idDocumento"));
                documentoVO.setDocumentoPDFmostrar(rs.getBytes("documentoPDF"));
                documentoVO.setVisualizaciones(rs.getInt("visualizaciones"));
                documentoVO.setIdRemitente(rs.getString("idRemitente"));
                documentoVO.setIdDestinatario(rs.getString("idDestinatario"));
                documentoVO.setIdRecepcionista(rs.getString("idRecepcionista"));
                documentoVO.setRespuestaPDFmostrar(rs.getBytes("respuestaPDF"));
                documentoVO.setRespuestaComen(rs.getString("respuestaComen"));
                documentoVO.setIdEstado(rs.getInt("idEstado"));
                documentoVO.setIdPrioridad(rs.getInt("idPrioridad"));
                documentoVO.setFechaRadicacion(rs.getDate("fechaRadicacion"));
                documentoVO.setIdOficina(rs.getInt("idOficina"));
                documentoVO.setIdtipoDocumento(rs.getInt("idtipoDocumento"));
                lista.add(documentoVO);
            }
            return lista;
        } catch (SQLException e) {
            throw new Exception("Error al listar la tabla recibidos" + e);
        } finally {
            Conexion.cerrar(ps, rs);
        }
    }//fin recibidos

    public boolean radicar(documentoVO documentoVO) throws Exception {
        ps = null;
        try {
            sql = "INSERT INTO documento(idDocumento,documentoPDF,visualizaciones,idRemitente,idDestinatario,idRecepcionista,idEstado,idPrioridad,fechaRadicacion,idOficina,idtipoDocumento)"
                    + "VALUES (2,"//idDocumento
                    + "?,"//PDF
                    + "0,"//Visualizaciones
                    + "?,"//idRemitente
                    + "1000225552,"//Destinatario
                    + "1000225552,"//Recepcionista
                    + "1,"//Estado
                    + "?,"//Prioridad
                    + "NOW(),"//fechaRadicacion
                    + "?,"//idOficina
                    + "?)";//idtipoDocumento
            ps = con.prepareStatement(sql);
            ps.setBlob(1, documentoVO.getDocumentoPDF());
            ps.setString(2, documentoVO.getIdRemitente());
            ps.setInt(3, documentoVO.getIdPrioridad());
            ps.setInt(4, documentoVO.getIdOficina());
            ps.setInt(5, documentoVO.getIdtipoDocumento());
            ps.executeUpdate();
            return false;
        } catch (SQLException e) {
            throw new Exception("Error al radicar documento" + e);
        } finally {
            Conexion.cerrar(ps, rs);
        }
    }//fin radicar

}//fin clase documentoDAO
