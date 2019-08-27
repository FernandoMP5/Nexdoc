/** @author Sena */
package co.edu.sena.Nexdoc.persistensia.dao;

import co.edu.sena.Nexdoc.persistensia.conexion.Conexion;
import co.edu.sena.Nexdoc.persistensia.vo.documentoVO;
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
    private ArrayList<documentoVO> lista = new ArrayList<>();

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
                documentoVO.setDocumentoPDF(rs.getBytes("documentoPDF"));
                documentoVO.setVisualizaciones(rs.getInt("visualizaciones"));
                documentoVO.setIdRemitente(rs.getString("idRemitente"));
                documentoVO.setIdDestinatario(rs.getString("idDestinatario"));
                documentoVO.setIdRecepcionista(rs.getString("idRecepcionista"));
                documentoVO.setRespuestaPDF(rs.getBytes("respuestaPDF"));
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
            throw new Exception("Error al listar la tabla recibidos");
        }finally{
            Conexion.cerrar(ps, rs);
        }
    }//fin recibidos

    public boolean radicar(documentoVO documentoVO) throws Exception {
        sql = "INSERT INTO documento(`idDocumento`,`documentoPDF`,visualizaciones,`idRemitente`,`idDestinatario`,`idRecepcionista`,`idEstado`,`idPrioridad`,`fechaRadicacion`,`idOficina`,`idtipoDocumento`)"
                + "VALUES ("+documentoVO.getIdDocumento()+","
                + "'"+documentoVO.getDocumentoPDF()+"',"
                + "'"+documentoVO.getVisualizaciones()+","
                + ""+documentoVO.getIdRemitente()+","
                + ""+documentoVO.getIdDestinatario()+","
                + ""+documentoVO.getIdRecepcionista()+","
                + ""+documentoVO.getIdEstado()+","
                + ""+documentoVO.getIdPrioridad()+","
                + "'"+documentoVO.getFechaRadicacion()+"',"
                + ""+documentoVO.getIdOficina()+","
                + ""+documentoVO.getIdtipoDocumento()+")";
        try {
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
            return false;
        } catch (SQLException e) {
            throw new Exception("Error al radicar documento");
        }finally{
            Conexion.cerrar(ps, rs);
        }
    }

}//fin clase documentoDAO
