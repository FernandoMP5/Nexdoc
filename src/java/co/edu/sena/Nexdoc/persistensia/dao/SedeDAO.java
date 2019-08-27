package co.edu.sena.Nexdoc.persistensia.dao;

import co.edu.sena.Nexdoc.persistensia.conexion.Conexion;
import co.edu.sena.Nexdoc.persistensia.vo.Sede;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class SedeDAO {

    private Connection con;
    private Conexion cn = new Conexion();
    private PreparedStatement ps = null;
    private ResultSet rs = null;
    private String sql = null;
    private ArrayList<Sede> list = new ArrayList<>();

    public SedeDAO(Connection con) {
        this.con = con;
    }

    public List listarSede() throws Exception {
        try {
            sql = "SELECT * FROM sede";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Sede sede = new Sede();
                sede.setIdSede(rs.getInt("IdSede"));
                sede.setNombre(rs.getString("Nombre"));
                list.add(sede);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("Error al listar las sedes");
        } finally {
            Conexion.cerrar(ps, rs);
        }
    }
}
