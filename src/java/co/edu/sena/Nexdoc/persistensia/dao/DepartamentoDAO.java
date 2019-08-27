package co.edu.sena.Nexdoc.persistensia.dao;

import co.edu.sena.Nexdoc.persistensia.conexion.Conexion;
import co.edu.sena.Nexdoc.persistensia.vo.Departamento;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class DepartamentoDAO {

    private Connection con;
    private PreparedStatement ps = null;
    private ResultSet rs = null;
    private String sql = null;
    private ArrayList<Departamento> list = new ArrayList<>(); 
    
    public DepartamentoDAO(Connection con) {
        this.con = con;
    }
    
    public List listarDepartamento() throws Exception {
        try {
            sql = "SELECT * FROM departamento";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Departamento Depa = new Departamento();
                Depa.setIdDepartamento(rs.getInt("IdDepartamento"));
                Depa.setDepartamento(rs.getString("Departamento"));
                list.add(Depa);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("Error al listar los departamentos");
        } finally {
            Conexion.cerrar(ps, rs);
        }
    }
}
