package co.edu.sena.Nexdoc.persistensia.dao;

import co.edu.sena.Nexdoc.persistensia.vo.Tipo_Documento;
import co.edu.sena.Nexdoc.persistensia.conexion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import java.util.ArrayList;

public class Tipo_DocumentoDAO {

    private Connection con;
    private PreparedStatement ps = null;
    private ResultSet rs = null;
    private String sql = null;
    ArrayList<Tipo_Documento> list = new ArrayList<>();

    public Tipo_DocumentoDAO(Connection con) {
        this.con = con;
    }

    public List listarTipoDoc() throws Exception {
        try {
            sql = "SELECT * FROM tipo_documento";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Tipo_Documento est = new Tipo_Documento();
                est.setIdTipo_Documento(rs.getInt("IdTipo_Documento"));
                est.setDescripcion(rs.getString("Descripcion"));
                list.add(est);
            }
        return list;
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("Error al listar los tipos de documentos");
        } finally {
            Conexion.cerrar(ps, rs);
        }
    }

}
