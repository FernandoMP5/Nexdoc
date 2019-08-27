package co.edu.sena.Nexdoc.persistensia.dao;

import co.edu.sena.Nexdoc.persistensia.conexion.Conexion;
import co.edu.sena.Nexdoc.persistensia.vo.Cargo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CargoDAO {

    private Connection con;
    private Conexion cn = new Conexion();
    private PreparedStatement ps = null;
    private ResultSet rs = null;
    private String sql = null;
    private ArrayList<Cargo> list = new ArrayList<>();

    public CargoDAO(Connection con) {
        this.con = con;
    }

    public List listarCargo() throws Exception {
        try {
            sql = "SELECT * FROM cargo";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Cargo car = new Cargo();
                car.setIdCargo(rs.getInt("IdCargo"));
                car.setDescripcion(rs.getString("Descripcion"));
                list.add(car);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("Error al listar la tabla cargo");
        } finally {
            Conexion.cerrar(ps, rs);
        }
    }
}
