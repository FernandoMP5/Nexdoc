package co.edu.sena.Nexdoc.persistensia.dao;

import co.edu.sena.Nexdoc.persistensia.conexion.Conexion;
import co.edu.sena.Nexdoc.persistensia.vo.Documento;
import co.edu.sena.Nexdoc.persistensia.vo.Tipo_Documento;
import co.edu.sena.Nexdoc.persistensia.vo.Oficina;
import co.edu.sena.Nexdoc.persistensia.vo.Persona;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DocumentoDAO {

    private final Connection con;
    private PreparedStatement ps = null;
    private ResultSet rs = null;
    private String sql = null;
    private final ArrayList<Documento> list = new ArrayList<>();

    public DocumentoDAO(Connection con) {
        this.con = con;
    }

    public List listar() throws Exception {
        try {
            sql = "SELECT O.Nombre,T.Descripcion,D.IdOficina,CONCAT(P.Nombre,' ', P.Apellido)Remitente,D.Fecha_Envio FROM documento D INNER JOIN remitente R ON D.IdRemitente=R.IdRemitente INNER JOIN tipo_documento T ON D.IdTipo_Documento=T.IdTipo_Documento INNER JOIN persona P ON P.IdPersona = R.IdPersona INNER JOIN oficina O ON D.IdOficina=O.IdOficina ORDER BY Fecha_Envio DESC";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Documento doc = new Documento();
                Tipo_Documento tip = new Tipo_Documento();
                Oficina ofi = new Oficina();
                Persona per = new Persona();
                per.setNombre(rs.getString("Remitente"));
                doc.setRemitente(per.getNombre());
                tip.setDescripcion(rs.getString("T.Descripcion"));
                doc.setIdTipoDocumento(tip.getDescripcion());
                ofi.setNombre(rs.getString("O.Nombre"));
                doc.setIdOficina(ofi.getNombre());
                doc.setFechaEnvio(rs.getDate("D.Fecha_Envio"));
                list.add(doc);
            }
            return list;
        } catch (SQLException e) {
            throw new Exception("Error al listar los documentos" + e);
        } finally {
            Conexion.cerrar(ps, rs);
        }
    }

    public boolean delete(int IdDocumento) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public boolean add(Documento Doc) throws Exception {
        sql = "INSERT INTO documento(IdRemitente,IdTipo_Documento,IdOficina,IdFuncionario,Documento,Fecha_Envio)\n"
                + "VALUES(" + Doc.getRemitente() + "," + Doc.getIdTipoDocumento() + "," + Doc.getIdOficina() + ",1,'" + Doc.getArchivopdf2()+ "',NOW())";
        try {
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
            return false;
        } catch (SQLException e) {
            throw new Exception("Error al radicar documento" + e);
        } finally {
            Conexion.cerrar(ps, rs);
        }
    }

    public boolean edit() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
