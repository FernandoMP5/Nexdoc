package co.edu.sena.Nexdoc.persistensia.dao;

import co.edu.sena.Nexdoc.persistensia.conexion.Conexion;
import co.edu.sena.Nexdoc.persistensia.vo.Tipo_Identificacion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class Tipo_IdentificacionDAO {

    private Connection con;
    private PreparedStatement ps = null;
    private ResultSet rs = null;
    private String sql = null;
    ArrayList<Tipo_Identificacion> list = new ArrayList<>();

    public Tipo_IdentificacionDAO(Connection con) {
        this.con = con;
    }

    public List listarTipo_Identificacion() throws Exception {
        try {
            sql = "SELECT * FROM tipo_identificacion";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Tipo_Identificacion Tipo = new Tipo_Identificacion();
                Tipo.setIdTipoIdentificacion(rs.getInt("IdTipo_Identificacion"));
                Tipo.setDescripcion(rs.getString("Descripcion"));
                list.add(Tipo);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("Error al listar los tipos de identificacion");
        } finally {
            Conexion.cerrar(ps, rs);
        }
    }
}
