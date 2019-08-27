package co.edu.sena.Nexdoc.persistensia.dao;

import co.edu.sena.Nexdoc.persistensia.conexion.Conexion;
import co.edu.sena.Nexdoc.persistensia.vo.Municipio;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MunicipioDAO implements co.edu.sena.Nexdoc.persistensia.intefaz.CRUD {

    private Connection con;
    private PreparedStatement ps = null;
    private ResultSet rs = null;
    private String sql = null;
    private ArrayList<Municipio> list = new ArrayList<>();

    public MunicipioDAO(Connection con) {
        this.con = con;
    }

    @Override
    public List listar() throws Exception {
        try {
            sql = "SELECT * FROM municipio";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Municipio Muni = new Municipio();
                Muni.setIdMunicipio(rs.getInt("IdMunicipio"));
                Muni.setNombre_Municipio(rs.getString("Nombre_Municipio"));
                Muni.setIdDepartamento(rs.getInt("IdDepartamento"));
                list.add(Muni);
            }
            return list;
        } catch (SQLException e) {
            throw new Exception("Error al listar los municipios" + e);
        } finally {
            Conexion.cerrar(ps, rs);
        }
    }

    @Override
    public boolean add() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean edit() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(int Id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
